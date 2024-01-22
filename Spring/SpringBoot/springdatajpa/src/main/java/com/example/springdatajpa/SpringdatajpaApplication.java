package com.example.springdatajpa;

import com.example.springdatajpa.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public void run(String... args) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			//JPA 관련 코드
//			User user = new User(); //DBMS와 연관을 맺고있기 때문에 entity 객체라고 부른다(@Entity 있음)
//			user.setName("원준연");
//			user.setEmail("wnsdus1008@gmail.com");
//			user.setPassword("1234");
//
//			entityManager.persist(user); //영속성을 갖게한다 - 프로그램이 종료되어도 남도독한다. -> DMBS에 저장해달라

			//update시에는 entityManager의 메소드를 호출하지 않아도 된다.
			//Entity Manager는 데이터에 대한 요청을 Persistence Context를 통해 한다.
			//이떄 요청한 정보에대한 스냅샷을 Persistence Context는 가지고 있다.
			//commit()이 일어나면 Persistence Context는 스냅샷과 현재의 user를 비교하여 변화가 일어났다면
			// 자동적으로 DBMS에 변경사항을 저장하는 명령을 내린다.
			User user = entityManager.find(User.class, 1);
			user.setPassword("5678");

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
