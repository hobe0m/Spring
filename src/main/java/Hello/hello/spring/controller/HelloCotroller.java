package Hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 컨트롤러는 해당 클래스가 컨트롤러라는 것을 알리기 위해 항상 컨트롤러 어노테이선을 붙여줘야 한다.
@Controller 
public class HelloCotroller {

    @GetMapping("hello") // 웹 애플리케이션에서 /hello로 들어오면 hello 메서드를 호출한다.
    public String hello(Model model) {
        // data라는 키, hello!!라는 값을 model에 넣어준다.
        model.addAttribute("data", "spring!!");
        // templates에서 hello라는 html파일을 찾고 그 화면을 실행시킨다.
        // 이 때, thymeleaf 템플릿 엔진 처리(사용할 경우)도 같이 진행된다.
        return "hello";
    }

    // 즉, 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(View Resolver)가 화면을 찾아서 처리한다.
    // 스프링 부트 템플릿 엔진 기본 viewName 매핑
    // resources:templates/ + {viewName} + .html
    //  - 이렇게 매핑이 되어 있어, resource의 templates에 hello.html을 찾아간다.

    // 참고
    // spring-boot-devtools 라이브러리를 추가하면 html 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.
    // Intellij 컴파일 방법 : 메뉴의 build -> Recompile

    // 동작 환경
    // 웹 브라우저에 localhost:8080/hello를 검색하면 스프링 부트에 내장된 톰캣 서버가 돌아간다.
    // 그 후 /hello이기 때문에, 컨트롤러에서 Get(직접 타이핑 한 주소) Mapping을 hello로 하는 것이 있는 지 찾는다.
    // 있다면 해당 메서드가 실행되는데 따라서 모델에 data라는 key와 hello!!라는 값을 넣은 뒤 hello를 반환한다.
    // 여기서 반환하는 hello 뷰와 연결하기 위한 것으로 뷰 리졸버에 의해 화면을 찾아서 처리한다.
    //  - 컨트롤러에서 리턴 값을 문자로 반환해 뷰 리졸버가 찾는 것
}
