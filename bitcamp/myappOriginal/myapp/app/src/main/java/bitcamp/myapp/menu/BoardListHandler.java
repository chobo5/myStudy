package bitcamp.myapp.menu;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

//게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
public class BoardListHandler implements MenuHandler {

    BoardRepository boardRepository;

    public BoardListHandler(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Override
    public void action(Prompt prompt) {
        System.out.println("게시글 목록입니다.");
        System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

        for (int i = 0; i < this.boardRepository.length; i++) {
            Board board = this.boardRepository.boards[i];
            System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
        }
    }
}