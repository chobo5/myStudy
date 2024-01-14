package com.example.board.dao;

import com.example.board.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {
    //Spring JDBC를 이용한 코드
    @Transactional //서비스에서 이미 트랜잭션이 시작되었기 때문에 그 트랜잭션에 포함된다.
    public User addUser(String name, String email, String password) {
        //insert into user(email, name, password, regDate) values(?, ?, ?, now()): #user_id auto gen
        //SELECT LAST_INSERT_ID();
        return null;
    }

    @Transactional
    public void mappingUserRole(int userId) {
        //insert into user_role(user_id, role_id) values (?,1);
    }
}
