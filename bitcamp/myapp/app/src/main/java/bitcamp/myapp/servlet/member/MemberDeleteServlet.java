package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
    private MemberDao memberDao;

    @Override
    public void init() {
        memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>비트캠프 데브옵스 5기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>회원 탈퇴</h1>");

        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            out.println("<p>로그인이 필요합니다</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Member member = memberDao.findBy(no);
            if (loginUser.getNo() == member.getNo()) {
                memberDao.delete(no);
            } else {
                out.println("<p>삭제하려는 회원과 로그인한 회원이 일치하지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            out.println("<p>회원탈퇴 완료</p>");
            out.println("<pre>");
            out.println("</pre>");

        } catch (Exception e) {
            out.println("<p>삭제 오류!</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
