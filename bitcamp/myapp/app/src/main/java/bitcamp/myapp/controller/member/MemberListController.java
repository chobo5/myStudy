package bitcamp.myapp.controller.member;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberListController implements PageController {

    private MemberDao memberDao;


    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", memberDao.findAll());
        return "/member/list.jsp";
    }
}