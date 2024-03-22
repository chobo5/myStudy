package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import bitcamp.util.DBConnectionPool;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {
    private final Log log = LogFactory.getLog(BoardDaoImpl.class);
    SqlSessionFactory sqlSessionFactory;

    public BoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
        log.debug("생성자 호출");
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Board board) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            sqlSession.insert("BoardDao.add", board);
        }
    }

    @Override
    public int delete(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.delete("BoardDao.delete", no);
        }
    }

    @Override
    public List<Board> findAll(int category) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("BoardDao.findAll", category);
        }
    }

    @Override
    public Board findBy(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("BoardDao.findBy", no);
        }
    }

    @Override
    public int update(Board board) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.update("BoardDao.update", board);
        }
    }
}
