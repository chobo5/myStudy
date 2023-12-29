package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Iterator;
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

        Iterator<Board> iterator = objectRepository.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%-20s\t%10s\t%3$tY-%3$tm-%3$td\n", board.getTitle(), board.getWriter(),
                    board.getCreatedDate());
        }

    }
}
