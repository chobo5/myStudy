package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member.getUsername());
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(String name) {
        List<Member> members = memberRepository.findByName(name);
        if (!members.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional //1. 트랜잭션 시작
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id); //2. 영속성 context에 저장후 리턴
        member.setUsername(name); //3. 변경 감지
        //메서드 종료시 트랜잭션 관련 aop 종료 -> 영속성 context flush -> transaction commit
    }
}
