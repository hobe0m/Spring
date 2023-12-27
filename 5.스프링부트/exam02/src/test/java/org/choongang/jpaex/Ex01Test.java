package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest // 의존성 주입 가능, 모의 객체 사용 가능
@Transactional // EntityManager 사용할 때 트랜잭션을 수동으로 처리 해야 오류 X
// @TestPropertySource(properties = "spring.profiles.active=test")
                    // application-test.yml이 설정 파일로 지정된다
public class Ex01Test {
    @PersistenceContext // 의존성 주입할 수 있도록 설정, Autowired와 동일
    private EntityManager em;


    @BeforeEach // 작업하기 전 초기 데이터를 넣을 때 많이 사용된다
    void init() {
        Member member = new Member();
        //member.setSeq(1L);
        member.setEmail("user-1@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear(); // 영속 상태 엔티티 모두 비우기
    }
    

    @Test
    void test1() {
       Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user-1@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        // Insert
        em.persist(member);
        // 영속성 컨텍스트에 영속 상태 - 변화 감지 시작
        // 상태 변화 감지 시작
        // 상태 변화 감지 메모리(영속성 컨텍스트) 안에 member를 넣는다

        em.flush();
        // 영구 반영

        // Update
        member.setName("(수정)사용자01");
        em.flush();

        /*
        em.remove(member); // 제거 상태로 변경
        em.flush();
        */

        em.detach(member); //  영속성 분리 - 변화 감지 X

        // Update
        member.setName("(수정2)사용자01");
        em.flush();
        // 영속성이 분리되었기 때문에 수정2는 이루어지지 않는다, 따라서 반영 X

        em.merge(member); // 분리된 영속 상태 엔티티 -> 영속 상태 : 변화 감지 O
        em.flush();


        // 영속성에서 분리하기 위해서는 Detached를 사용해야 한다
        // detach()
        // 분리된 영속성을 다시 집어 넣겠다 - merge() 사용

    }

    @Test
    void test2() {
        Member member = em.find(Member.class, 1L);
        // SQL 실행 -> 엔티티 -> 영속 상태
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        // 영속 상태 엔티티 -> 조회
        System.out.println(member2);
    }

    @Test
    void test3() {
        List<Member> members = em.createQuery("SELECT Member m FROM Member m",
                Member.class).getResultList();
        // JPQL
        // 엔티티명 기준 쿼리
        // 결과 자체, 영속성 상태 따라서 변화 감지 가능
        members.forEach(System.out::println);
    }
}
