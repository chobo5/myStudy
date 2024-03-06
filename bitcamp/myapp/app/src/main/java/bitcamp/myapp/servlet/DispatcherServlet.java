package bitcamp.myapp.servlet;

import bitcamp.myapp.controller.*;
import bitcamp.myapp.controller.AuthController;
import bitcamp.myapp.controller.BoardController;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.Component;
import bitcamp.util.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.*;


@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet(urlPatterns = "/app/*", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private Map<String, RequestHandler> requestHandlerMap = new HashMap<>();
    private List<Object> controllers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
            MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
            AssignmentDao assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
            AttachedFileDao attachedFileDao = (AttachedFileDao) this.getServletContext().getAttribute("attachedFileDao");
            TransactionManager txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");

            System.setProperty("board.upload.dir", this.getServletContext().getRealPath("/upload/board"));
            System.setProperty("member.upload.dir", this.getServletContext().getRealPath("/upload"));
//            controllers.add(new HomeController());
//            controllers.add(new AssignmentController(assignmentDao));
//            controllers.add(new AuthController(memberDao));
//            controllers.add(new BoardController(txManager, boardDao, attachedFileDao));
//            controllers.add(new MemberController(memberDao));

            preparePageControllers();
            prepareRequestHandlers(controllers);
        } catch (Exception e) {
            throw new ServletException();
        }

    }

    private void preparePageControllers() throws Exception {
        File classpath = new File("./build/classes/java/main");
        System.out.println(classpath.getCanonicalFile());
        findComponents(classpath, "");
    }

    private void findComponents(File dir, String packageName) throws Exception {
        File[] files = dir.listFiles(file -> file.isDirectory() ||
                (file.isFile() && !file.getName().contains("$") && file.getName().endsWith(".class")));
        if (packageName.length() > 0) {
            packageName += ".";
        }
        for (File file : files) {
            if (file.isFile()) {
                Class<?> clazz = Class.forName(packageName + file.getName().replace(".class", ""));
                Component componentAnno = clazz.getAnnotation(Component.class);
                if (componentAnno != null) {
                    Constructor constructor = clazz.getConstructor();
                    controllers.add(constructor.newInstance());
                    System.out.println(clazz.getName() + "객체 생성");
                }
            } else {
                findComponents(file, packageName + file.getName());
            }
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //URL 요청을 처리할 request handler를 찾는다.
            RequestHandler requestHandler = requestHandlerMap.get(request.getPathInfo());

            if (requestHandler == null) {
                throw new ServletException(request.getPathInfo() + " 요청 페이지를 찾을 수 없습니다.");
            }

            //페이지 컨트롤러가 작업한 결과를 담을 보관소를 준비한다.
            Map<String, Object> map = new HashMap<>();

            Object[] args = prepareRequestHandlerArguments(requestHandler.handler, request, response, map);

            String viewUrl = (String) requestHandler.handler.invoke(requestHandler.controller, args);

            //페이지 컨트롤러의 작업이 끝난 후 map 객체에 보관된 값을 JSP가 사용할 수 있도록
            //ServletRequest 보관소로 옮긴다.
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }

            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", request.getPathInfo() + "실행 오류");

            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            request.setAttribute("detail", stringWriter.toString());

            request.getRequestDispatcher("/error.jsp").forward(request, response);

        }
    }


    private void prepareRequestHandlers(List<Object> controllers) {
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();

            for (Method m : methods) {
                RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
                if (requestMapping != null) {
                    RequestHandler requestHandler = new RequestHandler();
                    requestHandlerMap.put(requestMapping.value(), new RequestHandler(controller, m));
                }
            }
        }
    }

    private Object[] prepareRequestHandlerArguments(Method handler,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response,
                                                    Map<String, Object> map) throws Exception {
        //요청 핸들러의 파라미터 정보를 알아낸다.
        Parameter[] params = handler.getParameters();

        //파라미터에 전달할 값을 담을 배열을 준비한다.
        Object[] args = new Object[params.length];

        //파라미터를 분석하여 각 파라미터에 맞는 값을 배열에 담는다.
        for (int i = 0; i < args.length; i++) {
            Parameter param = params[i];
            if (param.getType() == HttpServletRequest.class || param.getType() == ServletRequest.class) {
                args[i] = request;
            } else if (param.getType() == HttpServletResponse.class || param.getType() == ServletResponse.class) {
                args[i] = response;
            } else if (param.getType() == Map.class) {
                args[i] = map;
            } else if (param.getType() == HttpSession.class) {
                args[i] = request.getSession();
            } else {
                CookieValue cookieValueAnno = param.getAnnotation(CookieValue.class);
                if (cookieValueAnno != null) {
                    String value = getCookieValue(cookieValueAnno.value(), request);
                    if (value != null) {
                        args[i] = valueOf(value, param.getType());
                    }
                    continue;
                }
                RequestParam requestParam = param.getAnnotation(RequestParam.class);
                if (requestParam != null) {
                    // 클라이언트가 보낸 요청 파라미터 값을 원한다면
                    // 그 값을 메서드의 파라미터 타입을 변환한 후 저장한다.
                    String paramName = requestParam.value();

                    if (param.getType() == Part[].class) {
                        Collection<Part> parts = request.getParts();
                        List<Part> fileParts = new ArrayList<>();
                        for (Part part : parts) {
                            if (part.getName().equals(paramName)) {
                                fileParts.add(part);
                            }
                        }
                        args[i] = fileParts.toArray(new Part[0]);

                    } else if (param.getType() == Part.class) {
                        Collection<Part> parts = request.getParts();
                        for (Part part : parts) {
                            if (part.getName().equals(paramName)) {
                                args[i] = part;
                                break;
                            }
                        }

                    } else {
                        String paramValue = request.getParameter(paramName);
                        args[i] = valueOf(paramValue, param.getType());
                    }
                    continue;

                }
                //파라미터 타입이 도메인 클래스일 경우 해당 클래스의 객체를 준비한다.
                //그 객체에 요청 파라미터 값들을 담은 다음에 저장한다.
                args[i] = createValueObject(param.getType(), request);


            }
        }
        return args;
    }

    // 문자열을 주어진 타입으로 변환하여 리턴한다.
    private Object valueOf(String strValue, Class<?> type) {
        if (type == byte.class) {
            return Byte.parseByte(strValue);
        } else if (type == short.class) {
            return Short.parseShort(strValue);
        } else if (type == int.class) {
            return Integer.parseInt(strValue);
        } else if (type == long.class) {
            return Long.parseLong(strValue);
        } else if (type == float.class) {
            return Float.parseFloat(strValue);
        } else if (type == double.class) {
            return Double.parseDouble(strValue);
        } else if (type == boolean.class) {
            return Boolean.parseBoolean(strValue);
        } else if (type == char.class) {
            return strValue.charAt(0);
        } else if (type == Date.class) {
            return Date.valueOf(strValue);
        } else if (type == String.class) {
            return strValue;
        }
        return null;
    }

    //request handler의 파라미터 타입이 도메인 클래스일때,
    //해당 도메인 객체를 생성하고 요청 파라미터 값을 담아서 리턴한다.
    private Object createValueObject(Class<?> type, HttpServletRequest request) throws Exception {
        //1. 도메인 클래스의 생성자를 알아낸다.
        Constructor constructor = type.getConstructor();
        //2. 생성자를 이용하여 도메인 인스턴스를 생성한다.
        Object obj = constructor.newInstance();
        //3. 도메인 클래스의 메서드 목록을 가졍ㄴ다.
        Method[] methods = type.getDeclaredMethods();
        //4. 메서드 중에서 setter 메서드를 알아낸다.
        for (Method m : methods) {
            if (!m.getName().startsWith("set")) {
                continue;
            }

            //5. setter  메서드의 이름에서 프로퍼티 이름을 추출
            String propName = Character.toLowerCase(m.getName().charAt(3)) + m.getName().substring(4); //메서드 이름
            //6. 프로퍼티 이름으로 넘어온 요청파라미터 값을 꺼낸다.
            String requestParamValue = request.getParameter(propName);
            //7. 도메인 객체의 프로퍼티 이름과 일치하는 요청 파라미터 값이 있다면 객체에 저장한다.
            if (requestParamValue != null) {
                //setter 메소드의 파라미터 타입을 알아낸다.
                Class<?> setterParameterType = m.getParameters()[0].getType();
                //setter를 호출한다.
                m.invoke(obj, valueOf(requestParamValue, setterParameterType));
            }

        }
        return obj;
    }

    private String getCookieValue(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


}
