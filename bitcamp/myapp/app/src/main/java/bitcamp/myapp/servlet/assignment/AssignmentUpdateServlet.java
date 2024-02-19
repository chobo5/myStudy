package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.DBConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/assignment/update")
public class AssignmentUpdateServlet extends HttpServlet {
    AssignmentDao assignmentDao ;

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
            assignment.setTitle(req.getParameter("title"));
            assignment.setContent(req.getParameter("content"));
            assignment.setDeadline(Date.valueOf(req.getParameter("deadline")));
            assignmentDao.update(assignment);
            out.println("<p>과제 업데이트가 완료되었습니다.</p>");


        } catch (Exception e) {
            out.println("<p>업데이트 오류!</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

