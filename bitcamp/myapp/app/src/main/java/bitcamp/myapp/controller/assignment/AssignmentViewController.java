package bitcamp.myapp.controller.assignment;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.AssignmentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssignmentViewController implements PageController {

    private AssignmentDao assignmentDao;

    public AssignmentViewController(AssignmentDao assignmentDao) {
        this.assignmentDao = assignmentDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        request.setAttribute("assignment", assignmentDao.findBy(no));
        return "/assignment/view.jsp";
    }

}
