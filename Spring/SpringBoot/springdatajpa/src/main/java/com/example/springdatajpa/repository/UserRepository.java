package com.example.springdatajpa.repository;

import com.example.springdatajpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Spring Data Jpa Repository 완성
//보통 interface를 선언하면 interface를 구현하는 클래스를 작성한다.
//하지만 Spring Data Jpa는 UserRepository를 구현하는 bean을 자동으로 생성한다.
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name); //query method - Spring Data JPA
}
