package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor //모든 필드값을 초기화해주는 생성자를 만든다.
public class LoginInfo {
  private int userId;
  private String email;
  private String name;
}
