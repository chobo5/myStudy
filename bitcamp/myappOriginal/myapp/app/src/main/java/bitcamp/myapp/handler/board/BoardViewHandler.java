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
public class BoardViewHandler extends AbstractMenuHandler {

    private ArrayList<Board> objectRepository;

    public BoardViewHandler(Prompt prompt, ArrayList<Board> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    protected void action() {

        int index = this.prompt.inputInt("번호? ");

        Board board = this.objectRepository.get(index);

        if (board == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("작성일: %s\n", board.getCreatedDate());
    }
}
