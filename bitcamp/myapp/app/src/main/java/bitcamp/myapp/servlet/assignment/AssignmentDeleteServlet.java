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

@WebServlet("/assignment/delete")
public class AssignmentDeleteServlet extends HttpServlet {
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
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>과제</h1>");

        try {
            int no = Integer.parseInt(req.getParameter("no"));
            assignmentDao.delete(no);
            out.println("<p>과제 삭제가 완료되었습니다.</p>");
        } catch (Exception e) {
            System.out.println("<p>게시글 삭제 오류</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
