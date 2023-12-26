package org.choongang.jpaex;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
// application-test.yml을 사용하겠다

public class Ex02Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test1() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        // member.setCreatedAt(LocalDateTime.now());
        // CreationTimestamp, UpdateTimestamp를 사용했기 때문에 없어도 된다.

        em.persist(member);
        em.flush();
        em.clear();
        // clear 하고나면 영속성이 제거된 상태로 다시 쿼리가 수행된다.

        member = em.find(Member.class, member.getSeq());

        System.out.println(member);

        // @GeneratedValue를 통해 seq가 없어도, 알아서 증감번호가 생성된다.
        // 내부적으로 정책에 맞게 증감번호를 만들고, DB에도 추가한다.

        try {
            Thread.sleep(3000); // 3초 뒤로 시간 설정, 3초 지연
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.println(member);
    }

    @Test
    void test2() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        em.persist(member);
        em.flush(); // DB 반영

        System.out.printf("createdAt=%s, modifiedAt+%s%n",
                            member.getCreatedAt(), member.getModifiedAt());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();

        System.out.printf("createdAt=%s, modifiedAt+%s%n",
                member.getCreatedAt(), member.getModifiedAt());
    }

}