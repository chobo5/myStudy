package com.example.board.service;

import com.example.board.dao.UserDao;
import com.example.board.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //lombok이 final필드를 초기화하는 생성자를 자동으로 생성
public class UserService {
    private final UserDao userDao;

    //Spring이 UserSerivce를 Bean으로 생성할 생성자를 이용해 생성을 하는, 이떄 UserDao Bean이 있는 보고 그 bean을 주입해준다.


    //트랜젝션 단위로 실행될 메서드를 선언하고 있는 인터페이스
    //SpringBoot는 트랜잭션을 처리해주는 트렌잭션 관리자를 가지고 있다.
    @Transactional //하나의 트랜잭으로 처리하게 된다.
    public User addUser(String name, String email, String password){
        User sameUser = userDao.getUser(email); //이메일 중복겁사
        if (sameUser != null) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }
        //트렌젝션이 시작한다.
        User user = userDao.addUser(name, email, password);
        userDao.mappingUserRole(user.getUserId()); //권한을 부여한다.
        return user;
        //트렌젝션이 끝다.
    }

    @Transactional
    public User getUser(String email) {
        return userDao.getUser(email);
    }
}
