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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class RoleDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;
   private SimpleJdbcInsertOperations insertOperations;

   //스프링 부트가 자동으로 주입해준다. - 생성자 주입
    public RoleDao(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        insertOperations = new SimpleJdbcInsert(dataSource).withTableName("role");
    }

    public boolean addRole(Role role) {
        //Role의 프로퍼티를 활용한다. -> 이름 규칙이 맞아야 한다.
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        int result = insertOperations.execute(params);
        return result == 1;
    }

    public boolean deleteRole(int roleId) {
        String sql = "delete from role where role_id = :roleId";
        SqlParameterSource params = new MapSqlParameterSource("roleId", roleId);
        int result = jdbcTemplate.update(sql, params);
        return result == 1;
    }

    public Role getRole(int roleId) {
        String sql = "select * from role where role_id = :roleId";

        SqlParameterSource params = new MapSqlParameterSource("roleId", roleId);
        RowMapper<Role> roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);
        return jdbcTemplate.queryForObject(sql, params, roleRowMapper);
    }

    public List<Role> getRoles() {
        String sql = "select role_id, name from role order by role_id";
        RowMapper<Role> roleRowMapper = BeanPropertyRowMapper.newInstance(Role.class);
        return jdbcTemplate.query(sql,roleRowMapper);
    }
}
