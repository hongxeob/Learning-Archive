package study.dtajpa.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void testEntity() throws Exception {

        //given
        study.dtajpa.entity.Team teamA = new study.dtajpa.entity.Team("teamA");
        study.dtajpa.entity.Team teamB = new study.dtajpa.entity.Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        //when
        Member member1 = Member.builder().username("Member1").age(10).team(teamA).build();
        Member member2 = Member.builder().username("Member2").age(10).team(teamA).build();
        Member member3 = Member.builder().username("Member3").age(10).team(teamB).build();
        Member member4 = Member.builder().username("Member4").age(10).team(teamB).build();

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        //then
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team = " + member.getTeam());
        }
    }
}
