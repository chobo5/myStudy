package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.AttachedFile;
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
public class AttachedFileDaoImpl implements AttachedFileDao {
    private final Log log = LogFactory.getLog(AttachedFileDaoImpl.class);
    SqlSessionFactory sqlSessionFactory;

    public AttachedFileDaoImpl(SqlSessionFactory sqlSessionFactory) {
        log.debug("생성자 호출");
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(AttachedFile file) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.insert("AttachedFileDao.add", file);

        }
    }

    @Override
    public int addAll(List<AttachedFile> files) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
          return sqlSession.insert("AttachedFileDao.addAll", files);
        }
    }

    @Override
    public int delete(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.delete("AttachedFileDao.delete", no);
        }
    }

    @Override
    public int deleteAll(int boardNo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.delete("AttachedFileDao.deleteAll", boardNo);
        }
    }

    @Override
    public List<AttachedFile> findAllByBoardNo(int boardNo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("AttachedFileDao.findAllByBoardNo", boardNo);
        }
    }

    @Override
    public AttachedFile findByNo(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("AttachedFileDao.findByNo", no);
        }
    }
}
