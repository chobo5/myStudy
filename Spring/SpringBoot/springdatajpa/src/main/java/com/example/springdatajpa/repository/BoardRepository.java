package com.example.springdatajpa.repository;

import com.example.springdatajpa.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query(value = "select b from Board b join fetch b.user") //jpql을 사용할 수 있다. jpql은 sql과 모양이 비슷하지만 sql이 아니다. 객체지향 언어이다.
    List<Board> getBoards();

    @Query(value = "select count(b) from Board b")
    Long getBoardCount();

    //관리자가 쓴 글만 조회하는 JPQL
    

}
