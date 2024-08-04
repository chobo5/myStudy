package study.data_jpa.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.entity.Member;

import java.util.List;


@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberJpaRepositoryTest {
    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        Member member = new Member("userA");
        Member savedMember = memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findOne(savedMember.getId());

        Assertions.assertThat(savedMember).isEqualTo(findMember);

    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();

        Assertions.assertThat(findMember1).isEqualTo(member1);
        Assertions.assertThat(findMember2).isEqualTo(member2);

        //리스트 조회 검증
        List<Member> all = memberJpaRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);

        //개수 조회 검증
        long count = memberJpaRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        //삭제 검증
        Assertions.assertThat(memberJpaRepository.delete(member1)).isEqualTo(member1.getId());
        Assertions.assertThat(memberJpaRepository.delete(member2)).isEqualTo(member2.getId());
        Assertions.assertThat(memberJpaRepository.count()).isEqualTo(0);

    }

    @Test
    public void findByUsernameAndAgeGreaterThan() {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 30);
        Member member4 = new Member("member4", 40);
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);
        memberJpaRepository.save(member3);
        memberJpaRepository.save(member4);

        List<Member> members = memberJpaRepository.findByUsernameAndAgeGreaterThan("mem", 10);
        members.forEach(System.out::println);
    }

    @Test
    public void paging() {
        memberJpaRepository.save(new Member("member1", 19));
        memberJpaRepository.save(new Member("member2", 19));
        memberJpaRepository.save(new Member("member3", 19));
        memberJpaRepository.save(new Member("member4", 19));
        memberJpaRepository.save(new Member("member5", 19));

        int age = 19;
        int offset = 0;
        int limit = 3;
        List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
        members.forEach(System.out::println);
        long totalCount = memberJpaRepository.totalCount(age);
        System.out.println(totalCount);
    }

    @Test
    public void bulkUpdate() {
        memberJpaRepository.save(new Member("member1", 19));
        memberJpaRepository.save(new Member("member2", 19));
        memberJpaRepository.save(new Member("member3", 19));
        memberJpaRepository.save(new Member("member4", 19));
        memberJpaRepository.save(new Member("member5", 19));

        int resultCount = memberJpaRepository.bulkAgePlus(19);
        Assertions.assertThat(resultCount).isEqualTo(resultCount);
    }
}