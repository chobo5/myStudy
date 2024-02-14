package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;

import java.sql.Connection;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {
    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;

    public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
        this.attachedFileDao = attachedFileDao;
        this.boardDao = boardDao;
    }

    @Override
    protected void action(Prompt prompt) {
        try {
            int no = prompt.inputInt("번호? ");

            Board oldBoard = boardDao.findBy(no);
            if (oldBoard == null) {
                prompt.println("게시글 번호가 유효하지 않습니다.");
                return;
            }

            Board board = new Board();
            board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
            board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
            board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
            board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
            board.setCreatedDate(oldBoard.getCreatedDate());

            boardDao.update(board);

            List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
            prompt.println("첨부 파일 목록: ");
            for (AttachedFile file : files) {
                prompt.println(file.getNo() + ". " + file.getFilePath());
            }

            int selection = prompt.inputInt("1. 첨부파일 추가 \n2. 첨부파일 삭제 \n3. 첨부파일 전체 삭제 \n0. 이대로 게시물 수정 완료하기\n");
            switch (selection) {
                case 0:
                    break;
                case 1:
                    String filePath = prompt.input("추가할 첨부파일의 경로를 입력하세요: ");
                    AttachedFile file = new AttachedFile();
                    file.setBoardNo(no);
                    file.setFilePath(filePath);
                    attachedFileDao.add(file);
                    break;
                case 2:
                    int input = prompt.inputInt("삭제할 파일의 번호를 입력하세요");
                    attachedFileDao.delete(input);
                    break;
                case 3:
                    attachedFileDao.deleteAll(no);
                    break;
                default:
                    break;
            }

            prompt.println("게시글을 변경했습니다.");


        } catch (Exception e) {

        }
    }
}
