package member;


import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> memberList = new ArrayList<>();

    public void save(Member member) {
        memberList.add(member);
    }

    public Member findByNo(int no) {
        return memberList.get(no - 1);
    }

    public void delete(int no) {
        memberList.remove(no - 1);
    }

    public List<Member> list() {
        return memberList;
    }
}
