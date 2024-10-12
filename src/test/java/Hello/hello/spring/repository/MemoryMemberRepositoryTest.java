package Hello.hello.spring.repository;

import Hello.hello.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // MemoryMemberRepository 테스트 케이스 작성

    // 같은 위치에 패키지와 클래스를 만든다.
    // 굳이 public으로 만들지 않아도 된다.
    // 관례적으로 테스트 할 클래스명 뒤에 Test를 붙여서 명명한다.

    // @AfterEach를 사용하기 위해 MemberRepository repository = new MemoryMemberRepository();를 아래처럼 변경
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // MemoryMemberRepository를 만들고 Test를 했지만, 순서를 뒤집어서 Test를 먼저 만들수도 있다.
    // 검증할 수 있는 틀을 미리 만들어 놓는 것이다.
    //  - 이를 테스트 주도 개발(TDD, Test-Driven Development)라고 한다.

    // 테스트 코드가 없이 개발하는 것은 거의 불가능하고, 문제가 많이 생길 가능성이 높다.
    //  - 따라서 테스트 부분은 깊이 있게 공부하는 것이 중요하다.

    // 메서드 실행이 끝날 때마다 특정 동작을 반복하는 콜백 메서드
    // 리포지토리에 클리어 메서드를 만들어 준 뒤, @AfterEach를 사용해 넣어준다.
    // 테스트는 순서에 관계 없이, 의존 관계 없이 설계가 되어야 하므로 이 부분이 꼭 필요하다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // @Test annotation(org.junit.jupiter.api.Test)을 넣으면 실행할 수 있게 된다.
    // 따라서 작성한 코드(메서드 등)를 테스트 해볼 수 있다.
    @Test
    public void save() {
        Member member = new Member();
        member.setName("user1");

        repository.save(member);

        // Optional로 묶어놨기 때문에 get()을 통해 값을 꺼낸다.
        // 원래는 get()만 쓰는 것이 아니라 isPresent(), ifPresent(), orElse(), orElseGer(), orElseThrow() 등을 같이 사용하는데, 테스트 코드이기 때문에 get()만 사용했다..
        // isPresent() : 값이 있는 지 확인
        // ifPresent() : 값이 있을 때만 실행
        // orElse() : 값이 없을 때 지정한 기본 값 반환
        // orElseGet() : 값이 없으면 지정한 공급자로 제공된 함수를 호출하여 생성된 값 반환
        // orElseThrow() : 값이 없으면 지정한 예외를 던짐
        Member result = repository.findById(member.getId()).get();

        // 확인 방법 1
        // System.out.println("result = " + (result == member));

        // 확인 방법 2, org.junit.jupiter.api.Assertions의 assertEquals 사용
        // 보통 이 방법을 많이 쓴다.
        // assertEquals(기댓값, 비교값)으로 사용
        // Assertions.assertEquals(member, result);

        // 확인 방법 3, org.assertj.core.api.Assertions의 assertThat을 사용
        // assertThat(실제값).isEqualsTo(비교값)으로 사용
        // static import를 사용해서 assertThat을 바로 사용할 수 있다.
        assertThat(member).isEqualTo(result);

        // Assert : JUnit에서 테스트 결과를 검증하는 기본 클래스
        //  - assertTrue(boolean condition): 주어진 조건이 true인지 확인
        //  - assertFalse(boolean condition): 주어진 조건이 false인지 확인
        //  - assertNotNull(Object object): 주어진 객체가 null이 아님을 확인
        //  - assertEquals(expected, actual) : 두 개의 객체나 기본 타입의 값을 비교해 같은 지 확인, 다르면 테스트 실패
        //  - assertThat(actual, matcher) : 두 개의 객체나 기본 타입의 값을 비교해 같은 지 확인, 다르면 테스트 실패
        //   - assertEquals()에 비해 가독성이 높다.
        //   - Hamcrest와 같이 사용된다.
        //   - 내장되어서 따로 import 하지 않아도 되고, 가독성을 높여주는 라이브러리이다.

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("user1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("user2");
        repository.save(member2);

        // 이 과정을 하나로 줄이기 위해 get()을 사용한다.
        // Optional<Member> result = repository.findByName("user1");
        // Member resultName = result.get();

        Member result = repository.findByName("user1").get();
        // Member result = repository.findByName("user2").get();

        assertThat(result).isEqualTo(member1);
        // assertThat(result).isEqualTo(member2);

        // 테스트 클래스의 장점은 따로 하나씩 돌려볼 수도 있고 다 같이 돌려볼 수도 있다는 점이다.
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("user1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("user2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        // 두 개이기 때문에 size가 2이다.
        // 따라서 3이나 4와 같은 다른 숫자가 들어오면 에러가 발생한다.
    }
    
    // 각자 돌렸을 때 에러가 안났는데 같이 돌렸을 때 에러가 발생하는 이유
    // findAll()부터 실행되었을 때, 이미 멤버 객체가 만들어져 있어 에러가 발생
    // 따라서 테스트가 하나 끝나면 데이터를 클리어 시켜줘야 한다.
    // 그 때 사용하는 것이 콜백 메서드를 정의할 수 있게 해주는 @AfterEach이다.

    // @AfterEach를 사용해 콜백 메서드를 정의한 뒤 메서드가 끝날 때마다 사용될 메서드를 만든다.
    //  - 콜백 메서드 : 특정 이벤트가 발생했을 때 호출되는 메서드, 주로 비동기 작업이나 이벤트 처리에 사용
    //  - @AfterEach 어노테이션은 콜백 메서드 중에서도 각 테스트 메서드가 실행된 후에 항상 실행되는 메서드를 정의할 수 있게 해주는 어노테이션이다.
}
