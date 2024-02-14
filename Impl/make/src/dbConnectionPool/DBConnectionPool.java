package dbConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// 1. DB Connection 공유 (Single Connection)
// - 트랜잭션 관리의 어려움: 여러 클라이언트가 하나의 Connection 객체를 공유할 경우 어떤 클라이언트가 요청한 작업은 다른 클라이언트가 commit을 실행할때
// 함꺠 commit 되기 때문에 어떤 클라이언트가 실행한 rollback은 의도대로 실행 되지 않는다.
// - 스레드 안정성 문제: 여러 클라이언트가 하나의 데이터에 대해 수정, 삭제를 실행한다면 데이터의 무결성이 보장되지 않는다.

// 2. 스레드별로 DB Connection을 따로 유지하기
// - 스레드마다 다른 connection을 사용하므로 다른 스레드간의 commit/rollback에 영향을 받지 않는다.
// 2-1. SQL문을 실행할 때마다 Connection을 생성 - Transaction을 생성하기가 어렵다.
// 2-2. Thread 로컬 변수 활용하기 - 트랜잭션을 생성할 수 있지만 Thread 수만큼 connection이 생성되며 클라이언트가 사용하지 않을떄도
// connection이 남아있어 비용 낭비가 심하다.

// 3. 스레드별로 DB Connection을 따로 유지하며 connection 재활용하기
// - 따라서 다음과 같은 과정을 거쳐 connectio을 재활용하는 간단한 connection pool을 구현해 보았다.
public class DBConnectionPool implements ConnectionPool{
   private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
   private String jdbcUrl;
   private String username;
   private String password;
   private static final List<Connection> connections = new ArrayList<>();

    public DBConnectionPool(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        Connection con = connectionThreadLocal.get();
        if (con == null) {
            if (connections.size() > 0) {
                con = connections.remove(0);
            } else {
                con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, username, password), this);
                connections.add(con);
            }
            connectionThreadLocal.set(con);
        }
        return con;
    }

    public void returnConnection(Connection con) {
        //현재 스레드에 connection을 비운다.
        connectionThreadLocal.remove();
        connections.add(con);
    }

    public void closeAll() {
        for (Connection connection : connections) {
            ((ConnectionProxy)connection).realClose();
        }
    }
}
