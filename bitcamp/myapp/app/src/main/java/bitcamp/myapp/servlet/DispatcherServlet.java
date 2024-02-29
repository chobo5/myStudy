package bitcamp.myapp.servlet;

import bitcamp.myapp.controller.*;
import bitcamp.myapp.controller.assignment.*;
import bitcamp.myapp.controller.auth.LoginController;
import bitcamp.myapp.controller.auth.LogoutController;
import bitcamp.myapp.controller.board.*;
import bitcamp.myapp.controller.member.*;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.util.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

    private Map<String, PageController> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {

        BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
        MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
        AssignmentDao assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
        AttachedFileDao attachedFileDao = (AttachedFileDao) this.getServletContext().getAttribute("attachedFileDao");
        TransactionManager txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");

        String memberUploadDir = this.getServletContext().getRealPath("/upload");
        controllerMap.put("/home", new HomeController());

        controllerMap.put("/member/list", new MemberListController(memberDao));
        controllerMap.put("/member/view", new MemberViewController(memberDao));
        controllerMap.put("/member/add", new MemberAddController(memberDao, memberUploadDir));
        controllerMap.put("/member/update", new MemberUpdateController(memberDao, memberUploadDir));
        controllerMap.put("/member/delete", new MemberDeleteController(memberDao, memberUploadDir));

        controllerMap.put("/assignment/list", new AssignmentListController(assignmentDao));
        controllerMap.put("/assignment/view", new AssignmentViewController(assignmentDao));
        controllerMap.put("/assignment/add", new AssignmentAddController(assignmentDao));
        controllerMap.put("/assignment/update", new AssignmentUpdateController(assignmentDao));
        controllerMap.put("/assignment/delete", new AssignmentDeleteController(assignmentDao));

        controllerMap.put("/auth/login", new LoginController(memberDao));
        controllerMap.put("/auth/logout", new LogoutController());

        String boardUploadDir = this.getServletContext().getRealPath("/upload/board");
        controllerMap.put("/board/list", new BoardListContoller(boardDao));
        controllerMap.put("/board/view", new BoardViewController(boardDao, attachedFileDao));
        controllerMap.put("/board/add", new BoardAddController(txManager, boardDao, attachedFileDao, boardUploadDir));
        controllerMap.put("/board/update", new BoardUpdateController(txManager, boardDao, attachedFileDao, boardUploadDir));
        controllerMap.put("/board/delete", new BoardDeleteController(txManager, boardDao, attachedFileDao, boardUploadDir));
        controllerMap.put("/board/file/delete", new BoardFileDeleteController(boardDao, attachedFileDao, boardUploadDir));

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // URL에서 요청한 페이지 컨트롤러를 실행한다.
        PageController controller = controllerMap.get(request.getPathInfo());
        if (controller == null) {
            throw new ServletException(request.getPathInfo() + " 요청 페이지를 찾을 수 없습니다.");
        }
        try {
            String viewUrl = controller.execute(request, response);

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
}
