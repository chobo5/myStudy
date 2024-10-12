package board;

import menu.MenuCommand;

import java.io.BufferedReader;

public class BoardModifyCommand implements MenuCommand {

    private BufferedReader in;
    private BoardRepository boardRepository;

    public BoardModifyCommand(BufferedReader in, BoardRepository boardRepository) {
        this.in = in;
        this.boardRepository = boardRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("수정할 게시물 번호를 입력하세요");
            int boardNo = Integer.parseInt(in.readLine());

            Board board = boardRepository.findByNo(boardNo);

            System.out.println("제목:");
            String modiTitle = in.readLine();
            System.out.println("내용:");
            String modiContent = in.readLine();

            board.setTitle(modiTitle);
            board.setContent(modiContent);
            System.out.println("게시물 수정이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
