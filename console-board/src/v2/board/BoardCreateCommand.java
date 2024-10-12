package v2.board;

import v2.menu.MenuCommand;

import java.io.BufferedReader;

public class BoardCreateCommand implements MenuCommand {

    private BufferedReader in;
    private BoardRepository boardRepository;


    public BoardCreateCommand(BufferedReader in, BoardRepository boardRepository) {
        this.in = in;
        this.boardRepository = boardRepository;
    }


    @Override
    public void action() {
        try {
            System.out.println("작성자:");
            String writer = in.readLine();
            System.out.println("제목:");
            String title = in.readLine();
            System.out.println("내용:");
            String content = in.readLine();
            Board newBoard = new Board(writer, title, content);
            boardRepository.save(newBoard);
            System.out.println("게시물 작성이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
