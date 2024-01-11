package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.AbstractDao;
import bitcamp.myapp.vo.Board;

import java.util.List;

public class BoardDaoImpl extends AbstractDao<Board> {

    private int nextKey;

    public BoardDaoImpl(String filepath) {
        super(filepath);

        nextKey = list.getLast().getNo() + 1;
    }

    @Override
    public void add(Board board) {
        board.setNo(nextKey++);
        this.list.add(board);
        saveData();
    }

    @Override
    public int delete(int no) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNo() == no) {
                list.remove(i);
                saveData();
                return 1;
            }
        }

        this.list.remove(no);
        saveData();
        return 1;
    }

    @Override
    public List<Board> findAll() {
       return this.list.subList(0, list.size());
    }

    @Override
    public Board findBy(int no) {
        int index = indexOf(no);
        if (index == -1) {
            return null;
        }
        return list.get(index);
    }

    @Override
    public int update(Board board) {
        int index = indexOf(board.getNo());
        if (index == -1) {
            return 0;
        }
        list.set(index, board);
        saveData();
        return 1;
    }


    private int indexOf(int no) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}
