package com.example.demo.repository;

import com.example.demo.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


// Spring JDBC를 이용해서 Database 프로그래밍
//@Repository는 component이고 container가 관리하는 bean이된다.
@Repository
public class RoleDao {
//    private final JdbcTemplate jdbcTemplate; //필드를 final로 선언하면 반드시 생성자에서 초기화

    private SimpleJdbcInsertOperations insertAction; // insert를 쉽게 하도록 도와주는 인터페이스

    private final NamedParameterJdbcTemplate jdbcTemplate;

    //생성자에 파라미터를 넣어주면 스프링부트가 자동으로 주입해준다. - 생성자 주입
    public RoleDao(DataSource dataSource) {
        System.out.println("RoleDao 생성자 호출");
        System.out.println(dataSource.getClass().getName());
//        jdbcTemplate = new JdbcTemplate(dataSource); //Datasource를 넣어줘야 한다.

        insertAction = new SimpleJdbcInsert(dataSource).withTableName("role"); //insert할 테이블 이름을 넣어준다.
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    //role table에 한건 저장
    //저장에 성공하면 true 실패하면 false 리턴
    public boolean addRole(Role role) {
//        String sql = "INSERT INTO role(role_id, name) VALUES(?, ?)";
//        //update메서드는 insert, delete, update SQL문을 실행할때 사용
//        int result = jdbcTemplate.update(sql, role.getRoleId(), role.getName());
//        return result == 1;

    //----------------------------------------------------------------

        //SQL문이 작성되어 있지 않다.
        //INSERT INTO role(role_id, name) VALUES(:role_id, :name)
        //위와 같은 SQL을 SimpleJdbcInsertOperations가 내부적으로 만든다.
        //Role클래스의 프로퍼티이름과 컬럼명이 규칙이 맞아야 한다. ex) role_id => roleId 프로퍼
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        int result = insertAction.execute(params);
        return result == 1;
    }

    public boolean deleteRole(int roleId) {
//        String sql = "DELETE FROM role WHERE role_id = ?";
//        int result = jdbcTemplate.update(sql, roleId);
//        return result == 1;

        //----------------------------------------------------------------
        String sql = "DELETE FROM role WHERE role_id = :roleId";
        SqlParameterSource params = new MapSqlParameterSource("roleId", roleId);
        int result = jdbcTemplate.update(sql, params);
        return result == 1;
    }

    public Role getRole(int roleId) {
        String sql = "SELECT role_id, name FROM role WHERE role_id = :roleId";
        try {
            SqlParameterSource params = new MapSqlParameterSource("roleId", roleId);
            RowMapper<Role> roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);
            return jdbcTemplate.queryForObject(sql,params, roleRowMapper);
            //queryForObject() 한건의 결과를 얻을떄 사
//        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
//            Role role = new Role();
//            role.setRoleId(rs.getInt("role_id"));
//            role.setName(rs.getString("name"));
//            return role;
//        }, roleId);
//        return jdbcTemplate.queryForObject(sql, rm, roleId);
            //----------------------------------------------------------------

        } catch (Exception e) {
            return null;
        }



    }

    //데이터를 한건 읽어온 것을 성공한 것으로 가정하고, 한건의 데이터를 Role객체에 담아서 리턴하도록 한다.
    //다른 클래스에서 전혀 재상용될 가능성이 없을 경우 다음과 같이 익명클래스를 만든다.
//    RowMapper<Role> rm = new RowMapper<>() {
//        @Override
//        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Role role = new Role();
//            role.setRoleId(rs.getInt("role_id"));
//            role.setName(rs.getString("name"));
//            return role;
//        }
//    };

    public List<Role> getRoles() {
        String sql = "SELECT role_id, name FROM role ORDER BY role_id DESC";
        //query: 여러건의 결과를 구할떄 사용
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Role role = new Role();
//            role.setRoleId(rs.getInt("role_id"));
//            role.setName(rs.getString("name"));
//            return role;
//        });

        RowMapper<Role> roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);
        return jdbcTemplate.query(sql, roleRowMapper);
    }


}
