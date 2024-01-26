package com.example.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity //Database Table과 매핑하는 객체
@Table(name = "board")
@NoArgsConstructor
@Setter
@Getter
//@ToString //엔티티 관계를 표현할 때는 되도록 사용하지 않는다.(재귀적인 문제 발생)
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;

    @Column(length = 100)
    private String title;

    @Lob //대용량 텍스트로 인식
    private String content;

    private int viewCnt;

    @CreationTimestamp
    private LocalDateTime regdate;

    @ManyToOne(fetch = FetchType.LAZY) //게시물 N : 1 사용자 //FetchType.EAGER = 무조건 데이터를 가져와라 사용하지 않아도
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", regdate=" + regdate +
                '}';
    }
}
