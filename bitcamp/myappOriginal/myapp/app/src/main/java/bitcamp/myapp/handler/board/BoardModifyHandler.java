package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardModifyHandler extends AbstractMenuHandler {
    private BasicDao boardDao;

    public BoardModifyHandler(Prompt prompt, BasicDao boardDao) {
        super(prompt);
        this.boardDao = boardDao;
    }
    @Override
    protected void action() {
        int no = this.prompt.inputInt("번호? ");

        Board oldBoard = (Board) this.boardDao.findBy(no);

        if (oldBoard == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        Board newBoard = new Board();
        newBoard.setNo(oldBoard.getNo());
        newBoard.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
        newBoard.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
        newBoard.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
        newBoard.setCreatedDate(oldBoard.getCreatedDate());

       int result = this.boardDao.update(newBoard);
       if (result == 0) {
           System.out.println("게시글 변경 실패");
       } else {
           System.out.println("게시글을 변경했습니다.");
       }

    }
}
