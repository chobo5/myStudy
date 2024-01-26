package com.example.board.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity //Database Table과 매핑하는 객체
@Table(name = "user") //Database table 이름 user3와 User라는 객체가 매핑
@NoArgsConstructor
@Setter
@Getter
//@ToString
public class User {
    @Id //이 필드가 테이블의 PK
    @Column(name = "user_id") //userId 필드는 user_id 칼럼과 관리이 있다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // user_Id는 자동으로 생성된다. ex) 1 ,2, 3, 4
    private Integer userId;

    @Column(length = 255)
    private String email;

    @Column(length = 50)
    private String name;

    @Column(length = 500)
    private String password;

    @CreationTimestamp //현재시간이 저장될때 자동으로 생성
    private LocalDateTime regdate;

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>(); //User는 Role을 여러개 가질 수 있다.(user_role 관계테이블을 통해)
    //Role쪽에서는 User를 가져오지못하도록 단방향으로 설정했다.


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}


