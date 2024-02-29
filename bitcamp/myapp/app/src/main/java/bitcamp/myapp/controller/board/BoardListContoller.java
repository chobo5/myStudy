package bitcamp.myapp.controller.board;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.BoardDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardListContoller implements PageController {

    private BoardDao boardDao;

    public BoardListContoller(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int category = Integer.valueOf(request.getParameter("category"));
        String title = category == 1 ? "게시글" : "가입인사";

        request.setAttribute("category", category);
        request.setAttribute("title", title);
        request.setAttribute("list", boardDao.findAll(category));

        return "/board/list.jsp";

    }
}
