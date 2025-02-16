package Hello.hello.spring.controller;

import Hello.hello.spring.domain.Member;
import Hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    // 필드 주입 방법(권장 X)
    // @Autowired private MemberService memberService;
    // 스프링이 뜰 때만 넣어주고 중간에 바꿀 수 있는 방법이 없기 때문이다.

    // setter 주입 방법(권장 X)
    // private MemberService memberService;

    // public으로 생성되어 노출이 되므로 중간에 바뀔 우려가 있다.
    // 생성하는 시점에만 설정할 수 있게 하는 것이 좋은데, 누구든 언제나 변경할 수 있으므로 권장되지 않는다.
    //  @Autowired
    //  public void setMemberService(MemberService memberService) {
    //      this.memberService = memberService;
    //  }

    // 아까 Controller에 @Controller 어노테이션을 넣으면 컨테이너가 뜰 때 내부에 Controller 객체가 생긴다(생성자 호출)고 했었는데, @Autowired로 매개변수 MemberService를 넣어주면 생성 시 MemberService를 연결해서 생성해준다.
    // 연결 대상 둘 다 어노테이션이 붙어 있어야 스프링 컨테이너가 관리하는 빈이 될 수 있다.
    // 생성자에 @Autowired를 쓰면, MemberController가 생성될 때 스프링 빈에 등록되어 있는 MemberService 객체를 가져다가 넣어준다.
    // 이를 DI(Dependency Injection), 의존성 주입이라고 한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }

    // @GetMapping은 URL을 직접 치고 들어온다고 생각하면 된다.
    // 예를 들어 localhost:8080/members/new 이런 식이다.
    // URL은 같지만, GET이냐 POST냐에 따라 매핑을 달리 할 수 있다.
    @GetMapping("/members/new")
    public String createForm() {

        // @GetMapping이 return을 하면 templates 폴더에서 찾는다.
        // 따라서 templates에 있는 파일명을 적어주면 되고, 설정에서 경로를 바꿀 수도 있다.
        // localhost:8080/members/new를 검색해서 들어오면 templates/members/createForm을 보여준다.
        //  - viewResolve가 템플릿을 찾아서 띄워주고, thymeleaf가 동적 데이터들을 렌더링해서 보여준다.
        return "members/createMemberForm";
    }

    // 사용자가 데이터를 입력해 넘어온 POST 요청이 @PostMapping("/members/new")로 들어온다.
    @PostMapping("/members/new")
    // MemberForm의 name 필드에 html에서 input 태그에 지정한 name이 들어간다.
    // input 박스에 text를 넣고 submit 버튼을 누르면 @PostMapping("/members/new")으로 넘어와 메서드가 실행되는데 이 때, 스프링이 name을 보고 setName을 사용해 MemberForm에 넘겨준다.
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // 출력을 통해 name 값을 확인할 수 있다.
        // System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    // 메모리를 사용해서 저장하기 때문에, 서버를 내리면 데이터가 다 내려간다.
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
