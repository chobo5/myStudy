package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Session;
import bitcamp.util.TransactionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardAddHandler extends AbstractMenuHandler {

    TransactionManager txManager;
    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;

    public BoardAddHandler(TransactionManager txManager, BoardDao boardDao, AttachedFileDao attachedFileDao) {
        this.txManager = txManager;
        this.boardDao = boardDao;
        this.attachedFileDao = attachedFileDao;
    }

    @Override
    protected void action(Prompt prompt) {
        Member loginUser = (Member) prompt.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            prompt.println("로그인이 필요합니다");
            return;
        }
        Board board = new Board();
        board.setTitle(prompt.input("제목? "));
        board.setContent(prompt.input("내용? "));
        board.setWriter(loginUser);

        ArrayList<AttachedFile> files = new ArrayList<>();
        while (true) {
            String filePath = prompt.input("파일?(종료: 엔터) ");
            if (filePath.length() == 0) {
                break;
            }
            files.add(new AttachedFile().filePath(filePath));
        }

        try {
            txManager.startTransaction();
            boardDao.add(board);
            if (files.size() > 0) {
                //첨부 파일 객체에 게시글 번호 저장
                for (AttachedFile file : files) {
                    file.setBoardNo(board.getNo());
                }
                attachedFileDao.addAll(files);
            }
            txManager.commit();
        } catch (Exception e) {
            try {
                txManager.rollback();
                System.out.println("게시글 등록 오류");
            } catch (Exception ex) {
            }
        }
    }
}
