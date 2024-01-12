package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@Component가 붙어있는 것은 스프링 컨테이너가 관리하는 객체가 된다. 즉, Bean
@SpringBootApplication //스프링부트 설정파일이면서 컴포넌트이다.
public class DemoApplication implements CommandLineRunner {

	//main메소드는 Spring이 관리 안한다.(블럭이 실행되기 전까지는 관리하지 않는다.)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//Datasource Bean(Spring이 관리하는 객체)
//	@Autowired // 자동으로 주입받는다.
//	DataSource dataSource; //Spring이 객체를 만들어 넣어준다.
//	List<Object> beans; //Spring이 Object로 참조할 수 있는 모든 Bean을 주입해준다.

	@Autowired
	RoleDao roleDao;
	@Override
	public void run(String... args) throws Exception {
//		for(Object obj : beans) {
//			System.out.println(obj.getClass().getName());
//		}
//		System.out.println(dataSource.getClass().getName());


//		Connection conn = dataSource.getConnection();
		//DataSource로 부터 얻어온 connection은 close()실행시 종료가 아닌 connection pool에 되돌려주도록 되어있다.
//		conn.close();

		
		//connection pool은 한정된 connection을 가지고 있으면 connection이 반환되지 않으면 서버가 죽는다.
		//반드시 connection을 close해주고 빠른 sql을 실행할 수 있도록해야 한다.
//		List<Connection> conns = new ArrayList<>();
//		int i = 0;
//		while (true) {
//			Connection connection = dataSource.getConnection();
//			conns.add(connection);
//			System.out.println("Connection " + i + " : " + connection);
//			Thread.sleep(100);
//			i++;
//		}

//		Role role = new Role();
//		role.setRoleId(3);
//		role.setName("ROLE_TEST");
//
//		roleDao.addRole(role);

//		boolean flag = roleDao.deleteRole(3);
//		System.out.println("삭제여부: " + flag);

		Role role = roleDao.getRole(1);
		if (role != null) {
			System.out.println(role.getRoleId() + " " + role.getName());
		} else {
			System.out.println("error");
		}



//		List<Role> list = new ArrayList<>();
//		list = roleDao.getRoles();
//		list.forEach((role -> System.out.println(role.getRoleId() + ". " + role.getName())));


//		Role role = new Role();
//		role.setName("ROLE_TEST");
//		role.setRoleId(3);
//		roleDao.addRole(role);




	}
	//DemoApplication자체가 하나의 컴포넌트, 빈이 되어 메모리에 올라간다.




}
