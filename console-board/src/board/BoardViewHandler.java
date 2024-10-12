package board;

import menu.MenuHandler;

import java.io.BufferedReader;
import java.util.List;

public class BoardViewHandler implements MenuHandler {

    private BufferedReader in;
    private BoardRepository boardRepository;

    public BoardViewHandler(BufferedReader in, BoardRepository boardRepository) {
        this.in = in;
        this.boardRepository = boardRepository;
    }

    @Override
    public void action() {
        try {
            System.out.println("열람할 게시물 번호를 입력하세요");
            int boardNo = Integer.parseInt(in.readLine());
            Board board = boardRepository.findByNo(boardNo);
            System.out.println(board);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
