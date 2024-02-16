package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

    private TransactionManager txManager;
    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;

    public BoardUpdateServlet() {
        DBConnectionPool connectionPool = new DBConnectionPool(
                "jdbc:mysql://db-ld296-kr.vpc-pub-cdb.ntruss.com/studydb", "study", "Bitcamp!@#123");
        txManager = new TransactionManager(connectionPool);
        boardDao = new BoardDaoImpl(connectionPool, 1);
        attachedFileDao = new AttachedFileDaoImpl(connectionPool);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시글</h1>");


        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            out.println("<p>로그인이 필요합니다</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            Board board = boardDao.findBy(no);
            if (board == null) {
                out.println("<p>게시글 번호가 유효하지 않습니다.</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));

            List<AttachedFile> attachedFiles = new ArrayList<>();
            String [] files = request.getParameterValues("files");
            for (String file : files) {
                attachedFiles.add(new AttachedFile().filePath(file));
            }

//            board.setFiles(attachedFiles);

            txManager.startTransaction();

            boardDao.update(board);

            if (attachedFiles.size() > 0) {
                for (AttachedFile file : attachedFiles) {
                    file.setBoardNo(board.getNo());
                }
                attachedFileDao.addAll(attachedFiles);
            }

            if (loginUser.getNo() != board.getWriter().getNo()) {
                out.println("<p>수정 권한이 없습니다.</p>");
                out.println("</body>");
                out.println("</html>");
                txManager.rollback();
                return;
            }
            txManager.commit();

            out.println("<p>게시글을 변경했습니다.</p>");



        } catch (Exception e) {
            try {
                txManager.rollback();
            }
            catch (Exception e2) {
            }
            out.println("<p>게시글 등록 오류!</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}