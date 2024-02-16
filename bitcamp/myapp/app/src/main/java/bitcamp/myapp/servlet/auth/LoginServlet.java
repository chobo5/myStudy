package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/login")
public class LoginServlet extends GenericServlet {

    MemberDao memberDao;
    public LoginServlet() {
        DBConnectionPool connectionPool = new DBConnectionPool(
                "jdbc:mysql://db-ld296-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
        this.memberDao = new MemberDaoImpl(connectionPool);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


        //서블릿 컨테이너가 service()를 호출할때 실제 넘겨주는 값은 HttpServletRequest와 HttpServletResponse 이다.
        //getSession() 메소드는 HttpServletRequest에 있기 때문에 원래의 타입으로 형변환 해야 한다.
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>로그인</h1>");

        try {
            Member member = memberDao.findByEmailAndPassword(email, password);
            if (member != null) {
                request.getSession().setAttribute("loginUser", member);
                out.printf("<p>%s님 환영합니다.</p>\n", member.getName());
            } else {
                out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
            }
        } catch (Exception e) {
            out.println("<p>로그인 오류</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
