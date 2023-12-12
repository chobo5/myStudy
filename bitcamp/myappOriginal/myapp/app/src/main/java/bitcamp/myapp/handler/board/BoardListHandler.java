package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardListHandler implements MenuHandler {

    ObjectRepository objectRepository;

    public BoardListHandler(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");
        Board[] boards = (Board[]) this.objectRepository.toArray();

        if (boards == null) {
            System.out.println("게시물이 존재하지 않습니다.");
        }

        for (Board board : boards) {
            System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
        }
    }
}
