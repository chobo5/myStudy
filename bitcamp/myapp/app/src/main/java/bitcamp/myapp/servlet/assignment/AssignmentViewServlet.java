package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.util.DBConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/assignment/view")
public class AssignmentViewServlet extends HttpServlet {
    AssignmentDao assignmentDao;

    @Override
    public void init() {
        assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
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
        out.println("<h1>과제</h1>");

        try {
            int no = Integer.parseInt(req.getParameter("no"));

            Assignment assignment = assignmentDao.findBy(no);
            if (assignment == null) {
                out.println("<p>과제 번호가 유효하지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }


            out.println("<form action='/assignment/update'>");
            out.println("<div>");
            out.printf("  번호: <input readonly name='no' type='text' value='%d'>\n", assignment.getNo());
            out.println("</div>");
            out.printf("  제목: <input name='title' type='text' value='%s'>\n", assignment.getTitle());
            out.println("</div>");
            out.println("<div>");
            out.printf("  내용: <textarea name='content'>%s</textarea>\n", assignment.getContent());
            out.println("</div>");
            out.printf("  제출 기한: <input name='deadline' type='date' value='%s'>\n", assignment.getDeadline().toString());
            out.println("</div>");

            out.println("<div>");
            out.println("  <button>변경</button>");
            out.printf("  <a href='/assignment/delete?no=%d'>[삭제]</a>\n", no);
            out.println("</div>");
            out.println("</form>");

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
