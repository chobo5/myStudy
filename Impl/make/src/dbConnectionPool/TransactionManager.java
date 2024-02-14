package dbConnectionPool;

import java.sql.Connection;

public class TransactionManager {
    ConnectionPool connectionPool;

    public TransactionManager(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public void startTransaction() throws Exception {
        Connection con = connectionPool.getConnection();
        con.setAutoCommit(false);
    }
    public void commit() throws Exception {
        connectionPool.getConnection().commit();
        complete();
    }

    public void rollback() throws Exception {
        connectionPool.getConnection().rollback();
        complete();
    }

    public void complete() throws Exception {
        Connection con = connectionPool.getConnection();
        con.setAutoCommit(true);
        con.close();
    }
}
