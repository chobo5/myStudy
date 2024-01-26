package com.example.board.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity //Database Table과 매핑하는 객체
@Table(name = "role") //Database table 이름 user3와 User라는 객체가 매핑
@NoArgsConstructor
@Setter
@Getter
//@ToString //엔티티 관계를 표현할 때는 되도록 사용하지 않는다.(재귀적인 문제 발생)
public class Role {
    @Id
    @Column(name = "role_id") //userId 필드는 user_id 칼럼과 관리이 있다
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(length = 20)
    private String name;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }
}
