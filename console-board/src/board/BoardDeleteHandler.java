package board;

import assignment.AssignmentRepository;
import menu.MenuHandler;

import java.io.BufferedReader;

public class BoardDeleteHandler implements MenuHandler {

    private BufferedReader in;
    private BoardRepository boardRepository;

    public BoardDeleteHandler(BufferedReader in, BoardRepository boardRepository) {
        this.in = in;
        this.boardRepository = boardRepository;
    }

    @Override
    public void action() {
        try {
            System.out.println("삭제할 게시물 번호를 입력하세요");
            int boardNo = Integer.parseInt(in.readLine());

            boardRepository.delete(boardNo);
            System.out.println("게시물 삭제가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
