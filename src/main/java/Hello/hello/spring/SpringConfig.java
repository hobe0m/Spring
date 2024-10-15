package Hello.hello.spring;

import Hello.hello.spring.repository.MemberRepository;
import Hello.hello.spring.repository.MemoryMemberRepository;
import Hello.hello.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드로 컴포넌트 등록하는 방법
// SpringConfig 파일을 만들고, @Configuration 어노테이션을 붙여준다.
// 이후 @Bean을 사용해 주입하고자 컴포넌트로 등록하고자 하는 코드를 작성한다.

// 스프링이 뜰 때, Configuration을 읽고 MemberService와 MemberRepository를 빈으로 등록한다.
// 컨트롤러는 보통 컴포넌트 스캔으로 컨테이너의 빈에 등록한다.
@Configuration
public class SpringConfig {

    // 이 때 MemberService의 매개변수는 빈으로 등록된 Repository를 사용해야 하므로, memberRepository()를 매개변수에 넣어준다.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    
    // 참고
    // 과거에는 xml로도 설정했지만 최근에는 잘 사용하지 않으므로 생략한다.

    // 참고
    // DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다.
    // 의존 관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.

    // 참고
    // 실무에서는 주로 정형화 된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
    // 그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
    // 나중에 DB를 교체할 건데 그 때는 Config에 있는 레포지토리의 빈만, MemberRepository를 구현하는 새로운 레포지토리로 바꿔주면 되니까 이 방법을 사용한다.
    // 이렇게 직접 Config 파일을 사용하면 빈을 바꾸는데 있어서 용이하기 때문에 사용한다.

    // 주의
    // @Autuwired를 통한 DI는 helloController, MemberService 등과 같이 스프링이 관리하는 객체에서만 동작한다.
    // 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
    //  - 직접 new로 MemberService를 생성하면 Autowired가 적용되지 않는다.
    //  - 컨테이너에 올라가지 않고 직접 생성하는 것이기 때문이다.
    //  - 컨테이너에 올라가면 하나로 나눠쓴다는 점 유의
    // 즉, 빈으로 등록되어 있지 않으면 DI를 했더라도 동작하지 않는다.

    // 빈으로 등록하지 않고, Autowired를 사용할 수 없다.

    // 스프링 컨테이너, DI 관련된 자세한 내용은 스프링 핵심 원리 강의에서 설명한다.
}
