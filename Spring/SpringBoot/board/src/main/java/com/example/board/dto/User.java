package com.example.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor //기본생성자가 자동으로 만들어진다.
@ToString
public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private LocalDateTime regDate; //원래는 날짜 type으로 받아온후 문자열로 변환하는것이 좋다.


}
