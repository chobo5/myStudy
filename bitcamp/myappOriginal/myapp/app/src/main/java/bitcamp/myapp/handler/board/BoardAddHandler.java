package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardAddHandler implements MenuHandler {

    Prompt prompt;
    ArrayList<Board> objectRepository;

    public BoardAddHandler(Prompt prompt, ArrayList<Board> objectRepository) {
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
        objectRepository.add(board);
        //레퍼런스를 선언하는 시점에 지정된 타입이 아닌 값을 넣으려고 하면
        //컴파일 오류가 발생한다.
        //즉, 특정타입만 사용하도록 제한할 수 있는 문법이 제네릭(generic)이다.
//        objectRepository.add(new String("hello"));

    }
}
