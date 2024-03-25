package bitcamp.myapp.service;

import bitcamp.myapp.vo.Member;

import java.util.List;

public interface MemberService {
    void add(Member member);

    int update(Member member);

    List<Member> list();
    Member get(int no);

    int delete(int no);

    Member getByEmailAndPassword(String email, String password);
}
