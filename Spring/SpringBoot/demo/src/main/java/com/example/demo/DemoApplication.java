package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	//main메소드는 spring이 관리하지 않는다.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	DataSource dataSource;

	@Autowired
	RoleDao roleDao;

	@Override
	public void run(String... args) throws Exception {
//		Role role = new Role();
//		role.setRoleId(3);
//		role.setName("ROLE_TEST");
//		roleDao.addRole(role);

//		boolean flag = roleDao.deleteRole(3);
//		System.out.println(flag);

		System.out.println(roleDao.getRole(2));

	}



}