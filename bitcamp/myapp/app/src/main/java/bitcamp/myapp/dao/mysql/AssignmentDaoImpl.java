package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;

import bitcamp.util.DBConnectionPool;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentDaoImpl implements AssignmentDao {
    private final Log log = LogFactory.getLog(AssignmentDaoImpl.class);


    SqlSessionFactory sqlSessionFactory;

    public AssignmentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        log.debug("생성자 호출");
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Assignment assignment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            sqlSession.insert("AssignmentDao.add", assignment);
        }
    }

    @Override
    public int delete(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.delete("AssignmentDao.delete", no);
        }
    }

    @Override
    public List<Assignment> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("AssignmentDao.findAll");
        }
    }

    @Override
    public Assignment findBy(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("AssignmentDao.findBy", no);
        }
    }

    @Override
    public int update(Assignment assignment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.update("AssignmentDao.update", assignment);
        }
    }
}
