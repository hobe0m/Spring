package Hello.hello.spring.service;

import Hello.hello.spring.domain.Member;
import Hello.hello.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.channels.IllegalSelectorException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// 테스트에서는 기본적으로 정상 플로우가 아닌 예외 플로우 테스트를 더 중요시 한다.
class MemberServiceTest {

    // BeforeEach에서 만든 서비스를 넣는다.
    MemberService memberService;
    
    // AfterEach()를 통해 clear를 해줘야 하기 때문에 MemoryMemberRepository 사용
    // MemberService에서 쓰는 리포지토리랑 Test에서 사용하는 리포지토리가 상이하다.
    //  - new를 통해 객체를 생성해서 사용하기 때문이다.
    //  - 지금은 리포지토리의 store가 static으로 설정되어 있어 괜찮지만 나중에는 문제가 생길 수 있다.
    //  - 같은 리포지토리로 테스트 하는 게 맞지만 지금은 다른 리포지토리를 쓰고 있는 것이다.
    //  - 따라서 BeforeEach를 통해 해결한다.
    
    // BeforeEach에서 만든 리포지토리를 넣는다.
    MemoryMemberRepository memoryMemberRepository;

    // 각 테스트를 실행하기 전에, 리포지토리를 만들고, 그 리포지토리를 사용하는 서비스를 생성해준다.
    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    // 테스트 메서드 수행이 끝날 때마다 리포지토리를 클리어 한다.
    
    // shift + F10 : 이전에 실행했던 것 실행
    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    // 테스트는 메서드의 이름을 한글로 바꿔서 써도 된다.
    //  - 테스트의 경우에만 사용하고, 직관적으로 알아보기 위해 사용한다.

    // 테스트 코드 사용 시 Given - When - Then 문법 사용 권장
    // Given(주어진 조건) : 특정 상황이나 상태 설정
    // When(행동) : 사용자가 수행하는 행동이나 사건 설정
    // Then(결과) : 행동의 결과로 기대되는 상태나 결과 명시
    //  - 즉, 특정 상황에서 특정 로직 수행 시 기대되는 결과 값을 구하는 테스트 코드에서 유용하게 쓰인다.
    //  - Given이 주어졌을 때, When을 수행하면, Then이 나와야 된다고 이해하면 된다.
    //  - 또한 유지보수의 측면에서도 어떤 상황에서 무엇을 수행했을 때 어떤 결과가 나와야 하는 지를 한 눈에 볼 수 있어 유용하다.
    //  - 협업 시 특히 편하다고 할 수 있다.
    @Test
    void join() {
        // Given(주어진 상황)
        Member member = new Member();
        member.setName("user1");

        // When(수행 코드)
        Long saveId = memberService.join(member);


        // Then(기대되는 결과)
        // Assertions는 assertj와 Junit에서 제공하는데, assertThat은 assertj를 import해서 사용해야 한다.
        // Assertions : 테스트 검증 도구
        Member findMember = memberService.findOne(saveId).get();
        
        // static import로 넘겨 assertThat만 편하게 사용
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 테스트는 정상 플로우보다 예외 플로우를 처리하는 것이 더 중요하기 때문에, 검증을 잘 할 수 있는지를 테스트 한다.
    @Test
    public void DuplicationMemberException() {
        // Given(주어진 상황)
        Member member1 = new Member();
        member1.setName("user");

        Member member2 = new Member();
        member2.setName("user");

        // When(수행 코드)
        memberService.join(member1);

        // try - catch를 통해 테스트에서 중복 검증을 잘 하는지 확인하는 방법
        // member1과 member2의 이름이 동일할 때, 예외가 발생하고 예외를 잡아 그 메세지가 중복 시 출력되는 메세지와 일치하는지 확인

/*
        try {
            memberService.join(member2);
            // fail()은 실패를 예측하는 위치에 사용
            // 이 부분에서 예외가 터져 사용하지 못할 때, fail()의 내용이 잘 출력되는지 확인
            // 예외 검증, 중복 검사 등에 많이 사용된다.
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        // assertThrows를 사용하는 방법
        // memberService.join(member2) 로직 실행 시, IllegalStateException이 터져야 될 때 아래와 같이 작성
        // assertThrow는 타입 안전성을 위해 .class를 요구한다.
        // .class 파일을 제공받아, 해당 예외의 메타 데이터를 받아서 사용한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // 람다 풀이
        // memberService.join(member2)를 실행할 때, IllegalStateException이 발생해야 한다.

        // Then(기대되는 결과)
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    // 참고
    // 람다 인자 사용
    // - 인자가 없는 경우
    //  - () -> {
    //    System.out.println("Hello, World!");
    //    }

    // - 인자가 하나인 경우
    //  - name -> {
    //    System.out.println("Hello, " + name);
    //    }

    // - 인자가 두 개인 경우
    //  - (a, b) -> {
    //    return a + b;
    //    }
}