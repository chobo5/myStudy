package bitcamp.myapp.servlet.assignment;


import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;

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
    TransactionManager txManager;

    public AssignmentAddServlet() {
        DBConnectionPool connectionPool = new DBConnectionPool(
                "jdbc:mysql://db-ld296-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
        txManager = new TransactionManager(connectionPool);
        this.assignmentDao = new AssignmentDaoImpl(connectionPool);
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


        Assignment assignment = new Assignment();
        assignment.setTitle(req.getParameter("title"));
        assignment.setContent(req.getParameter("content"));
        System.out.println("-----------");
//        System.out.println(req.getParameter("deadline").getClass().getName());
        assignment.setDeadline(Date.valueOf(req.getParameter("deadline")));

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
