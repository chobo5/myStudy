package v2.board;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<Board> boardList = new ArrayList<>();

    public void save(Board board) {
        boardList.add(board);
    }

    public Board findByNo(int no) {
        return boardList.get(no - 1);
    }

    public void delete(int no) {
        boardList.remove(no - 1);
    }

    public List<Board> list() {
        return boardList;
    }
}
