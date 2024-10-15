package Hello.hello.spring.controller;

import Hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Spring이 뜰 때, Spring Container라는 통이 생기는데 @Controller 어노테이션이 있으면 컨테이너에 MemberController 객체를 넣어두고 스프링이 관리한다.
// 이를 스프링 컨테이너에서 스프링 빈이 관리된다고 한다.
// 지금은 컨트롤러 - 서비스 - 리포지토리까지 연결되어 있고 빈으로 등록되어 있으니, 컨테이너가 뜨면 3가지가 연결된 상태로 뜬다.
@Controller
public class MemberController {

    // 이렇게 쓰지 않고 이제 스프링 컨테이너에 등록해서 사용한다.
    // 별 기능이 없어 여러 개 생성할 필요 없이, 하나만 생성해서 사용하면 된다.
    // 이 외에도 부가적인 좋은 기능이 많지만 그건 뒤에서 설명한다.
    // private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    // 아까 Controller에 @Controller 어노테이션을 넣으면 컨테이너가 뜰 때 내부에 Controller 객체가 생긴다(생성자 호출)고 했었는데, @Autowired로 매개변수 MemberService를 넣어주면 생성 시 MemberService를 연결해서 생성해준다.
    // 연결 대상 둘 다 어노테이션이 붙어 있어야 스프링 컨테이너가 관리하는 빈이 될 수 있다.
    // 생성자에 @Autowired를 쓰면, MemberController가 생성될 때 스프링 빈에 등록되어 있는 MemberService 객체를 가져다가 넣어준다.
    // 이를 DI(Dependency Injection), 의존성 주입이라고 한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
