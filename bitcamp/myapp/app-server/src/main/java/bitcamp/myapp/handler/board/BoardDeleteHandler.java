package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;

import java.sql.Connection;

public class BoardDeleteHandler extends AbstractMenuHandler {
    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;

    public BoardDeleteHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
        this.attachedFileDao = attachedFileDao;
        this.boardDao = boardDao;
    }

    @Override
    protected void action(Prompt prompt) {
        try {
            int no = prompt.inputInt("번호? ");
            attachedFileDao.deleteAll(no);
            if (boardDao.delete(no) == 0) {
                prompt.println("게시글 번호가 유효하지 않습니다.");
            } else {
                prompt.println("삭제했습니다!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
