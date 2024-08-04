package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setUsername("member1");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member,  memberService.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setUsername("kim");

        Member member2 = new Member();
        member1.setUsername("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외가 발생해 이곳에 도달하면 안됨");
    }

}