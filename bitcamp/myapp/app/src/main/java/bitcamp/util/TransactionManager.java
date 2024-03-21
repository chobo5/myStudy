package bitcamp.util;

import java.sql.Connection;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
@Component
public class TransactionManager {

  ConnectionPool connectionPool;

  private final Log log = LogFactory.getLog(TransactionManager.class);


  public TransactionManager(ConnectionPool connectionPool) {
    log.debug("생성자 호출");
    this.connectionPool = connectionPool;
  }

  public void startTransaction() throws Exception {
    connectionPool.getConnection().setAutoCommit(false);
    log.debug(String.format("[%s] 트랜잭션 시작\n", Thread.currentThread().getName()));
  }

  public void commit() throws Exception {
    connectionPool.getConnection().commit();
    complete();
  }

  public void rollback() throws Exception {
    connectionPool.getConnection().rollback();
    complete();
  }

  private void complete() throws Exception {
    Connection con = connectionPool.getConnection();
    con.setAutoCommit(true);
    con.close();
    log.debug(String.format("[%s] 트랜잭션 종료\n", Thread.currentThread().getName()));
  }
}
