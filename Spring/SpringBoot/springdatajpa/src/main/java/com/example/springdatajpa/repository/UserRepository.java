package com.example.springdatajpa.repository;

import com.example.springdatajpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//Spring Data Jpa Repository 완성
//보통 interface를 선언하면 interface를 구현하는 클래스를 작성한다.
//하지만 Spring Data Jpa는 UserRepository를 구현하는 bean을 자동으로 생성한다.
public interface UserRepository extends JpaRepository<User, Integer> {
    // where name = ?
    Optional<User> findByName(String name); //query method - Spring Data JPA
    //where name = ? and email = ?
    Optional<User> findByNameAndEmail(String name, String email);
    //where name = ? or email = ?
    List<User> findByNameOrEmail(String name, String email);
    //where user_id between ? and ?
    List<User> findByUserIdBetween(int startUserId, int endUserId);
    //where user_id < ?
    List<User> findByUserIdLessThan(int userId);
    //where user_id <= ?
    List<User> findByUserIdLessThanEqual(int userId);
    //where user_id > ?
    List<User> findByUserIdGreaterThan(int userId);
    //where user_id >= ?
    List<User> findByUserIdGreaterThanEqual(int userId);

    //where regdate > ?
    List<User> findByRegdateAfter(LocalDateTime day);

    //where regdate < ?
    List<User> findByRegdateBefore(LocalDateTime day);

    //where name is null
    List<User> findByNameIsNull();

    //where name is not null;
    List<User> findByNameIsNotNull();

    //where name like ? (직접 % or _ 입력)
    List<User> findByNameLike(String name);

    //where name like ?%
    List<User> findByNameStartingWith(String name);

    //where name like %?
    List<User> findByNameEndingWith(String name);

    //where name like %?%
    List<User> findByNameContaining(String name);

    //select * from user3 order by name asc;
    List<User> findByOrderByNameAsc();

    //select * from user3 order by name desc;
    List<User> findByOrderByNameDesc();

    List<User> findByRegdateBeforeOrderByNameDesc(LocalDateTime day);

    //where name <> ? (null 비교 불가)
    List<User> findByNameNot(String name);

    //where user_id in (...);
    List<User> findByUserIdIn(Collection<Integer> userIds);

    //where user_id not in (...);
    List<User> findByUserIdNotIn(Collection<Integer> userIds);

    //select count(*) from user3
    Long countBy();

    //select count(*) from user3 where name like ?
    Long countByNameLike(String name);

    //where email = ?
    boolean existsByEmail(String email);

    //delete from user3 where name = ?
    int deleteByName(String name);

    //select distinct * from user3; (현재는 pk가 모두 다르기 때문에 의미가 없다)
    List<User> findDistinctByName(String name);

    //select * from user3 limit 2;
    List<User> findFirst2By(); //= fintTop2By();

    Page<User> findBy(Pageable pageable);

    Page<User> findByName(String name, Pageable pageable);
}
