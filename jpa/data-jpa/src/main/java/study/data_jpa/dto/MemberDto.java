package study.data_jpa.dto;

import lombok.Data;
import study.data_jpa.entity.Member;

@Data
public class MemberDto {
    private Long id;
    private String username;
    private int age;

    public MemberDto(Member member) {
        id = member.getId();
        username = member.getUsername();
        age = member.getAge();
    }
}
