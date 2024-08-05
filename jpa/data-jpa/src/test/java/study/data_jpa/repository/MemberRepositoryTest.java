package study.data_jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.data_jpa.entity.Member;
import study.data_jpa.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext
    EntityManager entityManager; //같은 transaction안에서는 같은 entityManager를 사용한다.

    @Test
    public void testMember() {
        Member member = new Member("userB");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow();

        Assertions.assertThat(savedMember).isEqualTo(findMember);

    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();

        Assertions.assertThat(findMember1).isEqualTo(member1);
        Assertions.assertThat(findMember2).isEqualTo(member2);

        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(2);

        //개수 조회 검증
        long count = memberRepository.count();
        Assertions.assertThat(count).isEqualTo(2);

        //삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);
        Assertions.assertThat(memberRepository.count()).isEqualTo(0);

    }

    @Test
    public void findByUsernameAndAgeGreaterThan() {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 30);
        Member member4 = new Member("member4", 40);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        List<Member> members = memberRepository.findByUsernameAndAgeGreaterThan("member4", 25);
        members.forEach(System.out::println);
    }

    @Test
    public void findByNames() {
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 30);
        Member member4 = new Member("member4", 40);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        List<String> names = new ArrayList<>();
        names.add(member1.getUsername());
        names.add(member2.getUsername());
        names.add(member3.getUsername());

        List<Member> members = memberRepository.findByNames(names);
        members.forEach(System.out::println);
    }

    @Test
    public void paging() {
        memberRepository.save(new Member("member1", 19));
        memberRepository.save(new Member("member2", 19));
        memberRepository.save(new Member("member3", 19));
        memberRepository.save(new Member("member4", 19));
        memberRepository.save(new Member("member5", 19));
        
        Pageable pageable = PageRequest.of(0, 3, Sort.by("username").descending());

        Page<Member> page = memberRepository.findByAge(19, pageable);
        
        List<Member> content = page.getContent();
        content.forEach(System.out::println);
        long count = page.getTotalElements();
        System.out.println(count);

        Assertions.assertThat(content.size()).isEqualTo(3);
        Assertions.assertThat(page.getTotalElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(page.isFirst()).isTrue();
        Assertions.assertThat(page.hasNext()).isTrue();

    }

    @Test
    public void bulkUpdate() {
        memberRepository.save(new Member("member1", 19));
        memberRepository.save(new Member("member2", 19));
        memberRepository.save(new Member("member3", 19));
        memberRepository.save(new Member("member4", 19));
        memberRepository.save(new Member("member5", 19));


        int resultCount = memberRepository.bulkAgePlus(19); //bulk 쿼리는 db에 바로 실행된다.
//        entityManager.flush();
//        entityManager.clear();

        memberRepository.findAll().forEach(System.out::println);// 따라서 영속성컨텍스트에 있는 entity들에는 변경내용이 반영되지 않는다.
        // entityManager를 flush 하고 clear해야함 or @Modifying(clearAuthmatically = true)

        Assertions.assertThat(resultCount).isEqualTo(5);
    }

    @Test
    public void entityGraph() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        entityManager.persist(teamA);
        entityManager.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(member3);
        entityManager.persist(member4);

        //초기화
        entityManager.flush();
        entityManager.clear();

        //확인
        List<Member> members = memberRepository.findEntityGraphByUsername("member2");
        members.forEach(member -> {
            System.out.println("member " + member);
            System.out.println("team " + member.getTeam());
            System.out.println("--------------------------");
        });
    }

    @Test
    public void callCustom() {
        List<Member> result = memberRepository.findMemberCustom();
    }

    @Test
    public void jpaEventBaseEntity() throws InterruptedException {
        //given
        Member member = new Member("member1");
        memberRepository.save(member); //@PrePersist

        Thread.sleep(100L);
        member.setUsername("member12");

        entityManager.flush(); //@PreUpdate
        entityManager.clear();

        //when
        Member findMember = memberRepository.findById(member.getId()).get();

        //then
        System.out.println("getCreatedDate: " + findMember.getCreatedDate());
        System.out.println("getUpdatedDate: " + findMember.getLastModifiedDate());
        System.out.println("getUpdatedDate: " + findMember.getCreatedBy());
        System.out.println("getUpdatedDate: " + findMember.getLastModifiedBy());
    }


}