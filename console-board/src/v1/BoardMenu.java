package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardMenu implements Menu {
    private BufferedReader in;

    List<Board> boardList = new ArrayList<>();

    public BoardMenu(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void execute() throws IOException {
        printMenu();
        String boardMenuNo = in.readLine();
        switch (boardMenuNo) {
            case "1":
                create();
                break;
            case "2":
                view();
                break;
            case "3":
                modify();
                break;
            case "4":
                delete();
                break;
            case "5":
                list();
                break;
        }
    }

    @Override
    public String getName() {
        return "게시판 메뉴";
    }

    public void printMenu() {
        System.out.println("1. 게시글 작성");
        System.out.println("2. 게시글 상세");
        System.out.println("3. 게시글 수정");
        System.out.println("4. 게시글 삭제");
        System.out.println("5. 게시글 목록");
    }

    public void create() throws IOException {
        System.out.println("작성자:");
        String writer = in.readLine();
        System.out.println("제목:");
        String title = in.readLine();
        System.out.println("내용:");
        String content = in.readLine();
        Board newBoard = new Board(writer, title, content);
        boardList.add(newBoard);
        System.out.println("게시물 작성이 완료되었습니다.");
    }

    public void view() throws IOException {
        System.out.println("열람할 게시물 번호를 입력하세요");
        int boardNo = Integer.parseInt(in.readLine());
        Board board = boardList.get(boardNo - 1);
        System.out.println(boardNo);
    }

    public void modify() throws IOException {
        System.out.println("수정할 게시물 번호를 입력하세요");
        int modiNo = Integer.parseInt(in.readLine());

        Board board = boardList.get(modiNo - 1);

        System.out.println("제목:");
        String modiTitle = in.readLine();
        System.out.println("내용:");
        String modiContent = in.readLine();

        board.setTitle(modiTitle);
        board.setContent(modiContent);
        System.out.println("게시물 수정이 완료되었습니다.");
    }

    public void delete() throws IOException {
        System.out.println("삭제할 게시물 번호를 입력하세요");
        int boardNo = Integer.parseInt(in.readLine());

        boardList.remove(boardNo - 1);
        System.out.println("게시물 삭제가 완료되었습니다.");
    }

    public void list() {
        for (int i = 0; i < boardList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(boardList.get(i));
        }
    }
}
