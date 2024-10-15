package Hello.hello.spring.controller;

public class Explain {
    // 컴포넌트 스캔과 자동 의존 주입

    // 스프링 빈을 등록하는 2가지 방법
    //  - 컴포넌트 스캔과 자동 의존 관계 설정
    //  - 자바 코드로 직접 스프링 빈 등록하기

    // 컴포넌트 스캔과 자동 의존 관계 설정
    // @Service, @Controller, @Repository라고 지정하는 것은, 컴포넌트 스캔 방식이다.
    // @Service, @Controller, @Repository 내부에 @Conponent가 있고, @Service, @Controller, @Repository가 아닌 @Component로 사용해도 빈으로 등록되기 때문이다.
    // 따라서 컴포넌트 스캔을 사용해 빈으로 등록한 뒤 연결하고자 하는 것들은 생성자에 @Autowired를 붙여 연결시킨다.
    //  - 서비스에서 레포지토리를 연결해서 사용하고 싶을 때
    //   - @Service라고 지정 후, private final Repository repository; 레포지토리 필드 선언 후 생성자를 만들고 생성자에 @Autowired를 붙여주면 된다.
    //   - 그렇게 하면 생성 시 연결이 되어서 생성된다.

    // @Component : 어노테이션이 있으면 스프링 빈으로 자동 등록된다.
    // @Controller : 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.

    // @Component를 포함하는 다음 어노테이션도 스프링 빈으로 자동 등록된다.
    //  - @Controller
    //  - @Service
    //  - @Repository

    // 기본 실행 파일인, application 클래스의 패키지 기준으로 해당 패키지와 그 하위만 Spring이 찾아볼 수 있다.
    //  - 따라서 그 범위를 넘어가면 등록을 해도 찾지 못한다.
    //  - 나중에는 추가 설정을 통해 범위를 넘어가는 컴포넌트들도 찾을 수 있다.

    // 참고
    // 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.
    //  - 이는 유일하게 하나만 등록해서 공유한다는 뜻이다.
    //  - @SpringController를 하나 등록하면 두 개는 등록할 수 없다.
    // 따라서 같은 스프링 빈이면 모두 같은 인스턴스다.
    // 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우가 아니라면 대부분 싱글톤을 사용한다.

    // 자바 코드로 직접 스프링 빈 등록하기
}
