package Hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// MVC : Model, Controller, View
//  - 이전에는 View에서 다 해결하는 Model1 방식을 사용했지만, 지금은 나눠서 관리하는 방식을 사용한다.

//  - View는 화면만, Controller는 비즈니스 로직이나 서버 뒷단과 관련된 것 관리
//   - 이 후, View에서 필요로 하는 것들을 Model에다가 담아서 넘긴다.

//  - 요즘 View와 Controller를 분리하는 것은 기본이다.

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

    @GetMapping("hello-mvc")
    // @RequestParam을 통해 외부에서 파라미터(String 타입)를 받는다.
    // @RequestParam의 required는 true(기본값)면 필수, false면 필수가 아니다.
    // url에 name = spring!을 추가했으므로, name이 spring으로 바뀌어 모델에 담긴다.
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
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

    // IDE를 통하지 않고 터미널로 빌드하기
    //  - CMD 창을 열고 스프링 프로젝트 디렉터리까지 경로를 이동한다.
    //  - gradlew.bat 명령어 실행
    //  - BUILD SUCCESSFUL이라는 문구가 나오면 gradlew build 명령어 실행
    //  - BUILD SUCCESSFUL 문구가 뜨면 빌드 성공
    //  - build 디렉터리에 ilbs라는 디렉터리가 생겼는지 확인(dir)
    //  - libs 디렉터리에서 프로젝트명(버전까지)-SNAPSHOT.jar 파일 존재하는지 찾기
    //  - java -jar 프로젝트명(버전까지).jar 명령어 실행
    //  - 성공했다면 spring 로고가 뜬다.

    // 사용하는 경우
    //  - 서버 배포 시 jar 파일만 복사해서 서버에 넣고 java -jar을 실행시키면 된다.
    //  - 그러면 서버에서도 스프링이 동작한다.
    //  - jar 파일 하나만 넣고 실행시키면 서버에서도 동작한다.

    //  - Spring Boot 프로젝트를 먼저 빌드(소스 코드를 컴파일하고 필요한 라이브러리를 모두 포함한 실행 가능한 JAR 파일을 생성)
    //  - jar 파일 복사
    //  - 서버에서 실행, 명령어를 통해 실행
    //  - 끌 때는 ctrl + c를 통해 종료시키면 된다.

    // 간편한 배포, 독립적 실행, 유연한 환경 구성이라는 장점이 있다.
    // gradlew.bat clean : 빌드 폴더 삭제
}
