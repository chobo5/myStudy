package com.example.demo.repository;

import com.example.demo.domain.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;

@Repository
public class RoleDao {
   private final JdbcTemplate jdbcTemplate;

   //스프링 부트가 자동으로 주입해준다. - 생성자 주입
    public RoleDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean addRole(Role role) {
        String sql = "insert into role(role_id, name) values(?, ?)";
        int result = jdbcTemplate.update(sql, role.getRoleId(), role.getName());
        return result == 1;
    }

    public boolean deleteRole(int roleId) {
        String sql = "delete from role where role_id = ?";
        int result = jdbcTemplate.update(sql, roleId);
        return result == 1;
    }

    public Role getRole(int roleId) {
        String sql = "select * from role where role_id = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setName(rs.getString("name"));
            return role;
        }, roleId);

    }
}
