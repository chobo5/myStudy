package com.example.demo.repository;

import com.example.demo.domain.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


// Spring JDBC를 이용해서 Database 프로그래밍
//@Repository는 component이고 container가 관리하는 bean이된다.
@Repository
public class RoleDao {
    private final JdbcTemplate jdbcTemplate; //필드를 final로 선언하면 반드시 생성자에서 초기화

    //생성자에 파라미터를 넣어주면 스프링부트가 자동으로 주입해준다. - 생성자 주입
    public RoleDao(DataSource dataSource) {
        System.out.println(dataSource.getClass().getName());
        jdbcTemplate = new JdbcTemplate(dataSource); //Datasource를 넣어줘야 한다.
    }

    //role table에 한건 저장
    //저장에 성공하면 true 실패하면 false 리턴
    public boolean addRole(Role role) {
        String sql = "INSERT INTO role(role_id, name) VALUES(?, ?)";
        //update메서드는 insert, delete, update SQL문을 실행할때 사용
        int result = jdbcTemplate.update(sql, role.getRoleId(), role.getName());
        return result == 1;
    }

    public boolean deleteRole(int roleId) {
        String sql = "DELETE FROM role WHERE role_id = ?";
        int result = jdbcTemplate.update(sql, roleId);
        return result == 1;
    }

    public Role getRole(int roleId) {
        String sql = "SELECT role_id, name FROM role WHERE role_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setName(rs.getString("name"));
            return role;
        }, roleId);

    }
}
