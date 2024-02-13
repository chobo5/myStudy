package com.example.demo;

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

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring이 관리하는 빈을 사용할 수 있다.");
		Connection con = dataSource.getConnection();

		//JDBC 프로그래밍
		PreparedStatement ps = con.prepareStatement("select * from x_board");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int boardId = rs.getInt("board_id");
			String title = rs.getString("title");
			String contents = rs.getString("contents");
			Date createdDate = rs.getDate("created_date");
			int viewCount = rs.getInt("view_count");
			System.out.println(title + " " + contents);
		}

		rs.close();
		ps.close();
		con.close();
	}



}