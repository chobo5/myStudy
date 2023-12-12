package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardAddHandler implements MenuHandler {

    Prompt prompt;
    ObjectRepository objectRepository;

    public BoardAddHandler(Prompt prompt, ObjectRepository objectRepository) {
        this.prompt = prompt;
        this.objectRepository = objectRepository;
    }

    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

        Board board = new Board();
        board.title = this.prompt.input("제목? ");
        board.content = this.prompt.input("내용? ");
        board.writer = this.prompt.input("작성자? ");
        board.createdDate = this.prompt.input("작성일? ");
        objectRepository.add((Object)board);

    }
}
