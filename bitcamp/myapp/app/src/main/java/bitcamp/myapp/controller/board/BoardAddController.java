package bitcamp.myapp.controller.board;

import bitcamp.myapp.controller.PageController;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class BoardAddController implements PageController {

    private TransactionManager txManager;
    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;
    private String uploadDir;

    public BoardAddController(TransactionManager txManager, BoardDao boardDao, AttachedFileDao attachedFileDao, String uploadDir) {
        this.txManager = txManager;
        this.boardDao = boardDao;
        this.attachedFileDao = attachedFileDao;
        this.uploadDir = uploadDir;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int category = Integer.parseInt(request.getParameter("category"));
        String title = category == 1 ? "게시글" : "가입인사";
        request.setAttribute("category", category);
        request.setAttribute("title", title);

        if (request.getMethod().equals("GET")) {
            return "/board/form.jsp";
        }
        try {
            Member loginUser = (Member) request.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                throw new Exception("로그인하시기 바랍니다!");
            }

            Board board = new Board();
            board.setCategory(category);
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            board.setWriter(loginUser);

            ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

            if (category == 1) {
                Collection<Part> parts = request.getParts();
                for (Part part : parts) {
                    if (!part.getName().equals("files") || part.getSize() == 0) {
                        continue;
                    }
                    String filename = UUID.randomUUID().toString();
                    part.write(this.uploadDir + "/" + filename);
                    attachedFiles.add(new AttachedFile().filePath(filename));
                }
            }

            txManager.startTransaction();
            boardDao.add(board);

            if (attachedFiles.size() > 0) {
                for (AttachedFile attachedFile : attachedFiles) {
                    attachedFile.setBoardNo(board.getNo());
                }
                attachedFileDao.addAll(attachedFiles);
            }

            txManager.commit();
            return "redirect:list?category=" + category;
        } catch (Exception e) {
            txManager.rollback();
            throw e;
        }




    }


}