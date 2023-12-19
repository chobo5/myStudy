package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

import java.util.ArrayList;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardAddHandler extends AbstractMenuHandler {


    private ArrayList<Board> objectRepository;

    public BoardAddHandler(Prompt prompt, ArrayList<Board> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }

    //접근제한 범위를 좁게 변경
    @Override
    protected void action() {

        Board board = new Board();
        board.setTitle(this.prompt.input("제목? "));
        board.setContent(this.prompt.input("내용? "));
        board.setWriter(this.prompt.input("작성자? "));
        board.setCreatedDate(this.prompt.input("작성일? "));
        objectRepository.add(board);
        //레퍼런스를 선언하는 시점에 지정된 타입이 아닌 값을 넣으려고 하면
        //컴파일 오류가 발생한다.
        //즉, 특정타입만 사용하도록 제한할 수 있는 문법이 제네릭(generic)이다.
//        objectRepository.add(new String("hello"));

    }
}
