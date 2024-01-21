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

			User user = entityManager.find(User.class, 1);
			System.out.println(user);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
