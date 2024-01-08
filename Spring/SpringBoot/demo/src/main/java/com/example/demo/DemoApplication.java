package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication //스프링부트 설정파일이면서 컴포넌트이다.
public class DemoApplication implements CommandLineRunner {

	//main메소드는 Spring이 관리 안한다.(블럭이 실행되기 전까지는 관리하지 않는다.)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//Datasource Bean(Spring이 관리하는 객체)
	@Autowired // 자동으로 주입받는다.
	DataSource dataSource; //Spring이 객체를 만들어 넣어준다.

	@Override
	public void run(String... args) throws Exception {
		//스프링부트가 관리하는 Bean을 사용할 수 있다.
		Connection connection = dataSource.getConnection();

		//JDBC 프로그래
		PreparedStatement ps = connection.prepareStatement("select role_id, name from role");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int roleId = rs.getInt("role_id");
			String name = rs.getString("name");
			System.out.println(roleId + ". " + name);
		}

		rs.close();
		ps.close();
		connection.close();

	}





}
