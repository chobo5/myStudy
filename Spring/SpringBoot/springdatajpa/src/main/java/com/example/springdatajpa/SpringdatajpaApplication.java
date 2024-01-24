package com.example.springdatajpa;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.domain.Role;
import com.example.springdatajpa.domain.User;
import com.example.springdatajpa.repository.BoardRepository;
import com.example.springdatajpa.repository.RoleRepository;
import com.example.springdatajpa.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional //메소드가 시작할떄 transaction이 시작, 메서드가 종료될떄 transaction이 commit, 중간에 RuntimeException 발생시 rollback
    public void run(String... args) throws Exception {
//        List<Role> all = roleRepository.findAll();
//        for (Role role : all) {
//            System.out.println(role);
//        }

//        List<User> users = userRepository.findAll();
//        for (User user : users) { //전체 개수를 가져오는 쿼리 1개
//            System.out.println(user);
//            for (Role role : user.getRoles()) { //쿼리가 반복
//                System.out.println(role);
//            }
//            System.out.println("-----------------");
//        }

        List<Board> boards = boardRepository.findAll();
        for(Board board : boards) {
            System.out.println(board);
        }
    }


}
