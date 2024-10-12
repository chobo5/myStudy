package v2.board;

import v2.menu.MenuHandler;

import java.io.BufferedReader;
import java.util.List;

public class BoardListHandler implements MenuHandler {

    private BufferedReader in;
    private BoardRepository boardRepository;

    public BoardListHandler(BufferedReader in, BoardRepository boardRepository) {
        this.in = in;
        this.boardRepository = boardRepository;
    }

    @Override
    public void action() {
        try {
            List<Board> boardList = boardRepository.list();
            for (int i = 0; i < boardList.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(boardList.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
