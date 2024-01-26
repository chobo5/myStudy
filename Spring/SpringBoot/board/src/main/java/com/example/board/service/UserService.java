package com.example.board.service;

import com.example.board.domain.Role;
import com.example.board.domain.User;
import com.example.board.repository.RoleRepository;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor //lombok이 final필드를 초기화하는 생성자를 자동으로 생성
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    //Spring이 UserSerivce를 Bean으로 생성할 생성자를 이용해 생성을 하는, 이떄 UserDao Bean이 있는 보고 그 bean을 주입해준다.


    //트랜젝션 단위로 실행될 메서드를 선언하고 있는 인터페이스
    //SpringBoot는 트랜잭션을 처리해주는 트렌잭션 관리자를 가지고 있다.
    @Transactional //하나의 트랜잭으로 처리하게 된다.
    public User addUser(String name, String email, String password){
        Optional<User> sameUser = userRepository.findByEmail(email); //이메일 중복겁사
        if (sameUser.isPresent()) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }
        //트렌젝션이 시작한다.
        Role role = roleRepository.findByName("ROLE_USER").get();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(role));

        return userRepository.save(user);
        //트렌젝션이 끝다.
    }

    @Transactional
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<String> getRoles(int userId) {
        Set<Role> roles = userRepository.findById(userId).orElseThrow().getRoles();
        List<String> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(role.getName());
        }

        return list;
    }
}
