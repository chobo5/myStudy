package bitcamp.myapp.servlet.assignment;


import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/assignment/add")
public class AssignmentAddServlet extends HttpServlet {
    AssignmentDao assignmentDao ;

    @Override
    public void init() {
        assignmentDao = (AssignmentDao) this.getServletContext().getAttribute("assignmentDao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>과제</h1>");


        Assignment assignment = new Assignment();
        assignment.setTitle(request.getParameter("title"));
        assignment.setContent(request.getParameter("content"));
        System.out.println("-----------");
//        System.out.println(req.getParameter("deadline").getClass().getName());
        assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));

        try {
            assignmentDao.add(assignment);
            out.println("<p>과제 등록이 완료되었습니다.</p>");
        } catch (Exception e) {
            System.out.println("<p>게시글 등록 오류</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
