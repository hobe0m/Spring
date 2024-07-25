public class BasicExplain {
    // 김영한의 스프링 입문
    // 개발 환경 설정

    // Gradle, Maven : 필요한 라이브러리(다른 사람이 만들어 놓은 코드 조각)를 프로젝트에 쉽게 추가해주고, 빌드(프로그램을 만들 때, 여러 파일들을 합쳐서 실행할 수 있는 형태로 만드는 작업)하는 라이프 사이클(코드 컴파일, 설정 파일 준비 등)까지 관리해주는 툴
    //  - 따라서 개발자가 복잡한 설정을 일일히 하지 않아도 된다.

    // Spring Boot의 버전은 릴리즈 된 버전(SNAPSHOT, M1과 같은 표시가 없는 것) 중 가장 최신 것 사용
    //  - SNAPSHOT은 아직 만들고 있는 버전, M1 정식 릴리즈 X

    // Project Metadata
    //  - Group : 보통 기업의 도메인명 작성
    //  - Artifact : 빌드되어 나온 결과물(프로젝트명)

    // Dependencies
    //  - 의존성 즉, 어떤 라이브러리를 사용할 것인지 정하는 부분
    //  - 현재 사용하고 있는 라이브러리
    //   - Thymeleaf : 웹브라우저에서 보이는 HTML을 만들기 위한 템플릿 엔진
    //   - Spring Web : web 프로젝트를 만들기 때문에 사용

    // 폴더의 구성
    // gradle : gradle을 쓰는 폴더
    // src : main, test로 구성
    // main : java(실제 패키지와 소스 파일 존재), resources(실제 자바 코드 파일을 제외한 나머지, html, 설정 파일 등)
    // test : 테스트 코드들과 관련된 소스(요즘에는 매우 중요)
    // build.gradle 파일 : 매우 중요, 버전 설정, 라이브러리 가져오기, 나중에 더 많은 학습이 필요
    //  - dependencies : 라이브러리 목록
    //  - repositories : MavenCentral라는 공개된 사이트에서 라이브러리를 다운 받으라고 설정해 둔 것

    // gitignore : 올라가면 안되는 파일, 소스코드를 제외한 설정파일들을 정리
    // gradle.w, gradle.w.bat : gradle로 빌드하는 과정을 통해 추후에 설명
    // setting.gradle : 추후에 학습

    // 실행하면, tomcat이라는 내장 서버가 돌아간다.

    // 라이브러리 살펴보기
    //  - External Libraries : 실제로 가져온 라이브러리들, build.gradle에 나와 있는 라이브러리보다 훨씬 많다.
    //   - starter-web을 가져오면, 필요로 하는 라이브러리들을 gradle 혹은 maven이 알아서 가져와준다.
    //   - 이렇게 하나의 라이브러리를 사용할 때 필수적으로 요구되는 라이브러리들의 관계를 의존 관계라고 한다.

    // log
    // 현업에서는 System.out.println()을 사용하지 않고, log(logging)를 사용한다.
    // 로깅 프레임 워크 : slf4j(인터페이스), logback(구현체)

    // 로깅은 운영 중인 웹 애플리케이션에 문제가 발생했을 경우, 문제의 원인을 파악하기 위해 문제 당시의 상화과 정보를 남겨두는 것
    //  - 예를 들어 Exception이 발생했거나, 중요 기능이 실행되는 부분에서 적절한 로그를 남겨야 한다.
    
    //  - 로그 레벨
    //   - trace(debug보다 세분화 된 정보)
    //   - debug(디버깅 하는데 유용한 세분화 된 정보) 
    //   - info(진행 상황 같은 일반 정보)
    //   - warn(오류는 아니지만 오류의 원인이 될 수 있는 경고성 정보)
    //   - error(요청 처리 중 문제 발생)

    // 출력보다 로깅을 하는 것이 구조화 된 로깅을 할 수 있고, 디버깅 및 문제 해결 과정에서 필요한 정보를 효과적으로 관리할 수 있어 사용한다.

    // 테스트를 할 때, junit이라는 라이브러리를 사용(핵심)
    // spring-test : 스프링과 통합해서 테스트를 할 수 있게 해주는 라이브러리

    // 정리
    // 핵심 라이브러리
    // 스프링 부트 라이브러리
    // spring-boot-starter-web
    //  - spring-boot-starter-tomcat(톰캣, 웹서버)
    //  - spring-webmvc : 스프링 웹 MVC

    // spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
    //  - spring-boot-starter(공통) : 스프링 부트 + 스프링 코어 + 로깅을 다 당겨온다.
    //   - spring-boot
    //    - spring-core
    //   - spring-boot-starter-logging
    //    - logback, slf4j

    // 테스트 라이브러리
    // spring-boot-starter-test
    //  - junit : 테스트 프레임워크
    //  - mokito : 목 라이브러리(참고)
    //  - assertj : 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리(참고)
    //  - spring-test : 스프링 통합 테스트 지원, 스프링이랑 통합해서 할 수 있게끔 해준다.
}
