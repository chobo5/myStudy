package study.querydsl.entity;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.querydsl.jpa.JPAExpressions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static study.querydsl.entity.QMember.*;
import static study.querydsl.entity.QTeam.*;

@SpringBootTest
@Transactional
class MemberTest {
    @Autowired
    EntityManager entityManager;

    JPAQueryFactory query;

    @BeforeEach
    public void before() {
        query = new JPAQueryFactory(entityManager);
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
    }

    @Test
    public void testEntity() {

        List<Member> members = entityManager.createQuery("select m from Member m", Member.class).getResultList();

        members.forEach(System.out::println);
    }

    @Test
    public void startJPQL() {
        Member findMember = entityManager.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();
        assertThat(findMember.getUsername()).isEqualTo("member1");

    }

    @Test
    public void startQuerydsl() {
        Member findMember = query.select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");

    }

    @Test
    public void search() {
        Member findMember = query.selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();
        assertThat(findMember.getUsername()).isEqualTo("member1");
        assertThat(findMember.getAge()).isEqualTo(10);
    }

    @Test
    public void searchAndParam() {
        Member findMember = query.selectFrom(member)
                .where(
                        member.username.eq("member1"),
                        member.age.eq(10)
                )
                .fetchOne();
        assertThat(findMember.getUsername()).isEqualTo("member1");
        assertThat(findMember.getAge()).isEqualTo(10);
    }

    @Test
    public void fetchResult() {
        List<Member> fetch = query.selectFrom(member).fetch();

        Member fetchOne = query.selectFrom(member).fetchOne();

        Member fetchFirst = query.selectFrom(member).fetchFirst();

        QueryResults<Member> fetchResults = query.selectFrom(member).fetchResults();
        fetchResults.getTotal();
        List<Member> content = fetchResults.getResults();

        long count = query.selectFrom(member).fetchCount();

    }

    @Test
    public void sort() {
        entityManager.persist(new Member(null, 100));
        entityManager.persist(new Member("member5", 100));
        entityManager.persist(new Member("member6", 100));

        List<Member> members = query.selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();
        members.forEach(System.out::println);
    }

    @Test
    public void paging1() {
        List<Member> result = query.selectFrom(member)
                .orderBy(member.username.desc())
                .offset(0)
                .limit(2)
                .fetch();
        result.forEach(System.out::println);
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void paging2() {
        QueryResults<Member> queryResults = query.selectFrom(member)
                .orderBy(member.username.desc())
                .offset(0)
                .limit(2)
                .fetchResults();

        assertThat(queryResults.getTotal()).isEqualTo(4);
        assertThat(queryResults.getResults().size()).isEqualTo(2);

    }

    @Test
    public void aggregation() {
        Tuple tuple = query.select(member.count(), member.age.sum(), member.age.avg(), member.age.min(), member.age.max())
                .from(member)
                .fetchFirst();

        assertThat(tuple.get(member.count())).isEqualTo(4);
        assertThat(tuple.get(member.age.sum())).isEqualTo(100);
        assertThat(tuple.get(member.age.avg())).isEqualTo(25);
        assertThat(tuple.get(member.age.min())).isEqualTo(10);
        assertThat(tuple.get(member.age.max())).isEqualTo(40);
    }

    /**
     * 팀의 이름과 각 팀의 평균 연령
     */
    @Test
    public void groupBy() {
        List<Tuple> result = query.select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name)
                .fetch();
        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);

        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(member.age.avg())).isEqualTo(15);
        assertThat(teamB.get(team.name)).isEqualTo("teamB");
        assertThat(teamB.get(member.age.avg())).isEqualTo(35);

    }

    /**
     * teamA에 소속된 모든 회원
     */
    @Test
    public void join() {
        List<Member> result = query.select(member)
                .from(member)
                .join(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        result.forEach(System.out::println);
        assertThat(result).extracting("username").containsExactly("member1", "member2");
    }

    @Test
    public void thetaJoin() {
        entityManager.persist(new Member("teamA"));
        entityManager.persist(new Member("teamB"));
        entityManager.persist(new Member("teamC"));

        List<Member> result = query.select(member)
                .from(member, team)
                .where(member.username.eq(team.name))
                .fetch();

        assertThat(result).extracting("username").containsExactly("teamA", "teamB");
    }

    /**
     * 회원과 팀을 조인하면서, 팀이름이 teamA인 팀 조인, 회원은 모두 조회
     */
    @Test
    public void joinOnFiltering() {
        List<Tuple> result = query.select(member, team)
                .from(member)
                .leftJoin(member.team, team)
                .on(team.name.eq("teamA"))
                .fetch();
        result.forEach(System.out::println);


    }

    @Test
    public void joinOnNoRelation() {
        entityManager.persist(new Member("teamA"));
        entityManager.persist(new Member("teamB"));
        entityManager.persist(new Member("teamC"));

        List<Tuple> result = query.select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();
        result.forEach(System.out::println);

    }

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    public void noFetchJoin() {
        entityManager.flush();
        entityManager.clear();

        Member findMember = query.selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("페치조인 미적용").isFalse();
    }

    @Test
    public void fetchJoin() {
        entityManager.flush();
        entityManager.clear();

        Member findMember = query.select(member)
                .from(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("페치조인 적용").isTrue();
    }

    /**
     * 나이가 가장 많은 회원 조회
     */
    @Test
    public void subQuery() {
        QMember subMember = new QMember("sub");
        Member findMember = query.selectFrom(member)
                .where(member.age.eq(
                        select(subMember.age.max()).from(subMember))
                )
                .fetchOne();

        assertThat(findMember.getAge()).isEqualTo(40);


    }

    /**
     * 나이가 평균이상인 회원
     */
    @Test
    public void subQueryGoe() {
        QMember subMember = new QMember("sub");
        List<Member> result = query.selectFrom(member)
                .where(member.age.goe(
                        select(subMember.age.avg()).from(subMember)
                ))
                .fetch();

        result.forEach(System.out::println);

    }

    @Test
    public void basicCase() {
        List<String> result = query.select(member.age
                        .when(10).then("열살")
                        .when(20).then("스무살")
                        .otherwise("기타"))
                .from(member)
                .fetch();
        result.forEach(System.out::println);

    }

    @Test
    public void complexCase() {
        List<String> result = query.select(new CaseBuilder()
                        .when(member.age.between(0, 19)).then("미성년자")
                        .otherwise("성인"))
                .from(member)
                .fetch();

        result.forEach(System.out::println);


    }

    @Test
    public void constant() {
        List<Tuple> result = query.select(member.username, Expressions.constant("A"))
                .from(member)
                .fetch();
        result.forEach(System.out::println);

    }

    @Test
    public void concat() {
        List<String> result = query.select(member.username.concat("_").concat(member.age.stringValue()))
                .from(member)
                .fetch();

        result.forEach(System.out::println);
    }

}