package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import bitcamp.util.DBConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class AssignmentAddHandler extends AbstractMenuHandler {

  DBConnectionPool connectionPool;
  private AssignmentDao assignmentDao;


  public AssignmentAddHandler(DBConnectionPool connectionPool, AssignmentDao assignmentDao) {
    this.connectionPool = connectionPool;
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(prompt.input("과제명? "));
      assignment.setContent(prompt.input("내용? "));
      assignment.setDeadline(prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

      con = connectionPool.getConnection();
      assignmentDao.add(assignment);
      assignmentDao.add(assignment);
      con.commit();
    } catch (Exception e) {
      prompt.println("과제 입력 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
      try {
        con.rollback();
      } catch (SQLException ex) {
      }
    } finally {
      connectionPool.returnConnection(con);
    }
  }
}
