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
}
