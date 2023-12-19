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
public class BoardModifyHandler extends AbstractMenuHandler {
    private ArrayList<Board> objectRepository;

    public BoardModifyHandler(Prompt prompt, ArrayList<Board> objectRepository) {
        super(prompt);
        this.objectRepository = objectRepository;
    }
    @Override
    protected void action() {
        int index = this.prompt.inputInt("번호? ");

        Board oldBoard = this.objectRepository.get(index);
        Board newBoard = new Board();

        if (oldBoard == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        newBoard.setTitle(this.prompt.input("제목(%s)? ", oldBoard.getTitle()));
        newBoard.setContent(this.prompt.input("내용(%s)? ", oldBoard.getContent()));
        newBoard.setWriter(this.prompt.input("작성자(%s)? ", oldBoard.getWriter()));
        newBoard.setCreatedDate(this.prompt.input("작성일(%s)? ", oldBoard.getCreatedDate()));

        this.objectRepository.set(index, newBoard);

    }
}
