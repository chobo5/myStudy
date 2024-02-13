package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.DBConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class BoardAddHandler extends AbstractMenuHandler {

  DBConnectionPool connectionPool;
  private BoardDao boardDao;

  public BoardAddHandler(DBConnectionPool connectionPool, BoardDao boardDao) {
    this.connectionPool = connectionPool;
    this.boardDao = boardDao;
  }

  @Override
  protected void action(Prompt prompt) {

    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    Connection con = null;
    try {
      con = connectionPool.getConnection();
      con.setAutoCommit(false);

      boardDao.add(board);
      boardDao.add(board);

      Thread.sleep(10000);

      boardDao.add(board);

      con.commit();
    } catch (Exception e) {
      try {
        con.rollback();
      } catch (SQLException ex) {
      }
    } finally {
      connectionPool.returnConnection(con);
    }

  }
}
