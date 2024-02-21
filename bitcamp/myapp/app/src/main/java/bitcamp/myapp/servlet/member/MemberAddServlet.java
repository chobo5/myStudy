package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
    private MemberDao memberDao;

    @Override
    public void init() {
        memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>비트캠프 데브옵스 5기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>회원 가입</h1>");

        try {
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String password2 = req.getParameter("password2");
            if (!password.equals(password2)) {
                out.println("<p>비밀번호가 일치하지 않습니다.</p>");
                out.println("<pre>");
                out.println("</pre>");
                return;
            }
            Member member = new Member();
            member.setEmail(email);
            member.setName(name);
            member.setPassword(password);
            memberDao.add(member);
            out.println("<p>회원가입 완료!</p>");
            out.println("<pre>");
            out.println("</pre>");

        } catch (Exception e) {
            out.println("<p>조회 오류!</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
