package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

import java.sql.Connection;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    int categoy;
    Connection con;

    public BoardDaoImpl(int categoy, Connection con) {
        this.categoy = categoy;
        this.con = con;
    }


    @Override
    public void add(Board board) {

    }

    @Override
    public int delete(int no) {
        return 0;
    }

    @Override
    public List<Board> findAll() {
        return null;
    }

    @Override
    public Board findBy(int no) {
        return null;
    }

    @Override
    public int update(Board board) {
        return 0;
    }
}
