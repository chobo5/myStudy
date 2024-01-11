package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BasicDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardViewHandler extends AbstractMenuHandler {

    private BasicDao boardDao;

    public BoardViewHandler(Prompt prompt, BasicDao boardDao) {
        super(prompt);
        this.boardDao = boardDao;
    }
    @Override
    protected void action() {

        int no = this.prompt.inputInt("번호? ");

        Board board = (Board) this.boardDao.findBy(no);

        if (board == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("NO: %d\n", board.getNo());
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("작성일: %s\n", board.getCreatedDate());
    }
}
