package com.example.springdatajpa;

import com.example.springdatajpa.domain.User;
import com.example.springdatajpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    UserRepository userRepository; //UserRepository를 구현하는 Bean을 자동으로 inject해준다.


    @Override
    @Transactional //메소드가 시작할떄 transaction이 시작, 메서드가 종료될떄 transaction이 commit, 중간에 RuntimeException 발생시 rollback
    public void run(String... args) throws Exception {
        //조회
//		System.out.println(userRepository.getClass().getName());
//		User user = userRepository.findById(1).orElseThrow();
//		System.out.println(user);

        //insert
//		User user = new User();
//		user.setName("둘리4");
//		user.setEmail("dool4@test.com");
//		user.setPassword("1234");
//		user.setRegdate(LocalDateTime.now());
//		User savedUser = userRepository.save(user);
//		if(savedUser == user) {
//			System.out.println("savedUser == user");
//		} else {
//			System.out.println("savedUser != user");
//		}

        //delete
//		userRepository.deleteById(2);

        //delete2
//		User user = userRepository.findById(3).orElseThrow();
//		userRepository.delete(user);

        //update
//		User user = userRepository.findById(4).orElseThrow();
//		System.out.println(user);
//		user.setPassword("5678");

        //이름으로 검색
//		User user = userRepository.findByName("원준연").orElseThrow();
//		System.out.println(user);
//
//		Optional<User> user2 = userRepository.findByNameAndEmail("둘리", "dool@test.com");
//		System.out.println(user2.get());
//
//		List<User> users = userRepository.findByNameOrEmail("둘리2", "dool@test.com");
//		for (User userr : users) {
//			System.out.println(userr);
//		}

//		List<User> users = userRepository.findByUserIdBetween(1, 3);
//		for (User userr : users) {
//			System.out.println(userr);
//		}

//        List<User> users = userRepository.findByUserIdLessThan(4);
//        for (User userr : users) {
//            System.out.println(userr);
//        }

//        List<User> users = userRepository.findByUserIdLessThanEqual(4);
//        for (User userr : users) {
//            System.out.println(userr);
//        }

//        List<User> users = userRepository.findByRegdateAfter(LocalDateTime.now().minusDays(2L));
//        for (User userr : users) {
//            System.out.println(userr);
//        }

//        List<User> users = userRepository.findByNameIsNull();
//        for (User userr : users) {
//            System.out.println(userr);
//        }

//        List<User> users = userRepository.findByNameLike("둘리%");
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<User> users = userRepository.findByNameLike("둘리_");
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<User> users = userRepository.findByOrderByNameAsc();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<User> users = userRepository.findByOrderByNameDesc();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<User> users = userRepository.findByRegdateBeforeOrderByNameDesc(LocalDateTime.now().minusDays(1L));
//        for (User user : users) {
//            System.out.println(user);
//        }

//        List<User> users = userRepository.findByUserIdIn(List.of(2, 3, 5));
//        for (User user : users) {
//            System.out.println(user);
//        }

        List<User> users = userRepository.findByUserIdNotIn(List.of(2, 3, 5));
        for (User user : users) {
            System.out.println(user);
        }
    }

}
