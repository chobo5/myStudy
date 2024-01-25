package com.example.springdatajpa;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.domain.Role;
import com.example.springdatajpa.domain.User;
import com.example.springdatajpa.dto.BoardIf;
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
import java.util.Set;

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

//        List<Board> boards = boardRepository.getBoards();
//        for(Board board : boards) {
//            System.out.println(board);
//        }

//        Board board = boardRepository.findById(3).get();
//        System.out.println(board);

//        System.out.println(boardRepository.getBoardCount());

//        Role role = roleRepository.findById(2).get();
//        System.out.println(role);
//
//        User user = new User();
//        user.setName("관리자");
//        user.setEmail("super@test.com");
//        user.setPassword("1234");
//        user.setRegdate(LocalDateTime.now());
//        user.setRoles(Set.of(role));
//        userRepository.save(user);

//        User user = userRepository.findById(9).get();
//        Board board = new Board();
//        board.setUser(user);
//        board.setRegdate(LocalDateTime.now());
//        board.setTitle("관리자의 글");
//        board.setContent("내용");
//        boardRepository.save(board);

//        List<Board> boardAdmin = boardRepository.getBoards("ROLE_ADM");
//        for (Board board : boardAdmin) {
//            System.out.println(board);
//        }

        List<BoardIf> list = boardRepository.getBoardsWithNativeQuery();
        for (BoardIf board : list) {
            System.out.println(board.getClass().getName());
            System.out.println(board.getName());
            System.out.println(board.getTitle());
        }

    }



}
