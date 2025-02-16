package Hello.hello.spring.repository;

import Hello.hello.spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    /*
    JPA 사용의 장점(2015년부터 국내에서도 점유율이 높아지고 있다.
    - JPA를 사용하게 되면, 기존의 반복적인 코드는 물론, 기본적인 SQL도 직접 만들어서 실행해준다.
    - SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환할 수 있다.
    - 개발 생산성을 크게 높일 수 있다.

    application.properties 설정
    - spring.jpa.show.sql=true : JPA가 사용하는 SQL을 확인할 수 있다.
    - spring.jpa.hibernate.ddl-auto=none : 객체를 보고 테이블도 직접 생성해주지만, 지금은 만들어진 걸 사용하기 때문에 기능을 꺼놓는다.
      - create로 설정하면 자동으로 만들어준다.
    */

    // JPA는 EntityManager로 모든 것이 동작한다.
    // 매핑해서 통신하는 역할을 한다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    public Member save(Member member) {
        // persist : 영속하다.
        em.persist(member);
        return member;
    }
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public List<Member> findAll() {
        // JPQL을 짜야한다.
        // - Spring Data JPA(JPA를 Spring으로 감싸서 사용) 사용 시 JPQL을 안짜도 된다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    } public Optional<Member> findByName(String name) {
        // JPQL을 짜야한다.
        // - Spring Data JPA(JPA를 Spring으로 감싸서 사용) 사용 시 JPQL을 안짜도 된다.
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
