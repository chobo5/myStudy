package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import bitcamp.util.DBConnectionPool;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {
    private final Log log = LogFactory.getLog(MemberDaoImpl.class);
    SqlSessionFactory sqlSessionFactory;

    public MemberDaoImpl(SqlSessionFactory sqlSessionFactory) {
        log.debug("생성자 호출");
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void add(Member member) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            sqlSession.insert("MemberDao.add", member);
        }
    }

    @Override
    public int delete(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.delete("MemberDao.delete", no);
        }
    }

    @Override
    public List<Member> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("MemberDao.findAll");
        }
    }

    @Override
    public Member findBy(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("MemberDao.findBy", no);
        }
    }

    @Override
    public int update(Member member) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.update("MemberDao.update", member);
        }
    }

    @Override
    public Member findByEmailAndPassword(String email, String password) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("email", email);
            data.put("password", password);
            return sqlSession.selectOne("MemberDao.findByEmailAndPassword", data);
        }
    }

}
