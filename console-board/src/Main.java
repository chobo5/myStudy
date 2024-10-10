import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("콘솔 보드 프로그램 시작");
        List<Board> boardList = new ArrayList<>();
        while(true) {
            System.out.println("1. 게시글 작성");
            System.out.println("2. 게시글 수정");
            System.out.println("3. 게시글 삭제");
            System.out.println("4. 게시글 목록");

            String menuNo = in.readLine();

            switch (menuNo) {
                case "1":
                    System.out.println("작성자:");
                    String writer = in.readLine();
                    System.out.println("제목:");
                    String title = in.readLine();
                    System.out.println("내용:");
                    String content = in.readLine();
                    Board newBoard = new Board(writer, title, content);
                    boardList.add(newBoard);
                    break;
                case "2":
                    System.out.println("수정할 게시물 번호를 입력하세요");
                    int modiNo = Integer.parseInt(in.readLine());
                    System.out.println("제목:");
                    String modiTitle = in.readLine();
                    System.out.println("내용:");
                    String modiContent = in.readLine();
                    Board board = boardList.get(modiNo - 1);
                    board.setTitle(modiTitle);
                    board.setContent(modiContent);
                    break;
                case "3":
                    System.out.println("수정할 게시물 번호를 입력하세요");
                    int deleteNo = Integer.parseInt(in.readLine());
                    boardList.remove(deleteNo - 1);
                    break;
                case "4":
                    for (int i = 0; i < boardList.size(); i++) {
                        System.out.print(i + 1 + ". ");
                        System.out.println(boardList.get(i));
                    }
                    break;
            }

        }

    }
}