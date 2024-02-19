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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

    MemberDao memberDao;
    @Override
    public void init() {
        this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
