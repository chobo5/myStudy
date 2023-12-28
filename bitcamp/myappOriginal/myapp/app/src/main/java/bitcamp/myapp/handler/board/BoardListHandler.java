package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.List;
import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardListHandler extends AbstractMenuHandler {

    private List<Board> objectRepository;

    public BoardListHandler(Prompt prompt, List<Board> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    @Override
    protected void action() {
        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

//        Board[] boards = new Board[this.objectRepository.size()];

        Object[] objects = this.objectRepository.toArray();

        if (objects == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;
        }

        Board[] boards = this.objectRepository.toArray(new Board[0]);

        for (Object object : objects) {
            Board board = (Board) object;
            System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n", board.getTitle(), board.getWriter(),
                    board.getCreatedDate());
        }
    }
}
