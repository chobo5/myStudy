package com.example.springweb.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "ToDo") //Persistence Context가 관리해주는 Entity의 이름
@Table(name = "todo") //데이터베이스에 생성될 테이블 이름
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ToDo {
    @Id //유일성을 보장하기 위해 id를 지정 - Table의 primary key와 관계를 맺고있.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String todo;
}
