package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardModifyHandler implements MenuHandler {
    ObjectRepository objectRepository;
    Prompt prompt;

    public BoardModifyHandler(Prompt prompt, ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
        this.prompt = prompt;
    }
    @Override
    public void action(Menu menu) {
        System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
        int index = this.prompt.inputInt("번호? ");

        Board oldBoard = (Board) this.objectRepository.get(index);
        Board newBoard = new Board();

        if (oldBoard == null) {
            System.out.println("게시글 번호가 유효하지 않습니다.");
            return;
        }

        newBoard.title = this.prompt.input("제목(%s)? ", oldBoard.title);
        newBoard.content = this.prompt.input("내용(%s)? ", oldBoard.content);
        newBoard.writer = this.prompt.input("작성자(%s)? ", oldBoard.writer);
        newBoard.createdDate = this.prompt.input("작성일(%s)? ", oldBoard.createdDate);

        this.objectRepository.set(index, (Object) newBoard);

    }
}
