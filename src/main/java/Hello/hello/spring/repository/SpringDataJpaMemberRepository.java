package Hello.hello.spring.repository;

import Hello.hello.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
// 해당 프레임 워크가 기본 메서드들을 전부 제공해준다.
// 기본적인 CRUD 및 findByName(), findByEmail() 등 메서드 이름만으로 조회하는 기능 제공, 페이징 기능 자동 제공

// 참고
// 실무에서는 JPA와 스프링 데이터 JPA를 기본으로 사용하고, 복잡한 동적 쿼리는 QueryDSL이라는 라이브러리를 사용해서 해결한다.
// QueryDSL을 사용하면 쿼리도 자바 코드로 안전하게 작성할 수 있고, 동적 쿼리도 편리하게 작성할 수 있다.
// 이 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리(직접 SQL을 작성)를 사용하거나, 앞서 학습한 스프링 JdbcTemplate를 사용하면 된다.
import java.util.Optional;

// interface가 interface를 상속받을 때는 extends를 사용한다.
// class - interface는 implements 사용

// 스프링 데이터 JPA가 해당 인터페이스를 보고 자동으로 Spring bean으로 만든다.
// 우리는 이 객체를 인젝션 해서 사용하는 것
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 스프링 데이터 JPA
    //  - 스프링 부트와 JPA만 사용해도 개발 생산성이 많이 증가하고, 개발해야 할 코드도 확연히 줄어든다.
    //  - 그러나 스프링 데이터 JPA를 사용하면, 기존의 한계를 넘어 리포지토리에 구현 클래스 없이 인터페이스만으로 개발을 완료할 수 있다.
    //  - 그리고 반복 개발해 온 기본 CRUD도 스프링 데이터 JPA가 모두 제공한다.
    //  - 따라서 스프링 부트와 JPA라는 기반 위에 스프링 데이터 JPA를 더하면 개발이 더 편해져, 요즘에는 필수적인 요소가 되었다.

    // 주의
    //  - 처음부터 스프링 데이터 JPA를 배우는 것이 아닌, JPA를 먼저 선행해야 한다.
    @Override
    Optional<Member> findByName(String name);
}
