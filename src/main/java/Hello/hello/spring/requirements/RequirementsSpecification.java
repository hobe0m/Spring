package Hello.hello.spring.requirements;

public class RequirementsSpecification {
    // 회원 관리
    // 비즈니스 요구사항 정리

    // 데이터 : 회원 ID, 이름
    // 기능 : 회원 등록, 조회
    // 아직 데이터 저장소가 선정되지 않았으므로 가상의 시나리오 사용

    // 일반적인 웹 애플리케이션 계층 구조
    // 컨트롤러 -> 서비스
    // 서비스 -> 리포지토리 
    // 리포지토리 -> DB
    // 컨트롤러, 서비스, 리포지토리 -> 도메인

    // 컨트롤러 : 웹 MVC의 컨트롤러 역할
    // 서비스 : 핵심 비즈니스 로직 구현(도메인 객체를 가지고 구현)
    // 리포지토리 : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리(도메인은 회원, 상품 등)
    // 도메인 : 비즈니스 도메인 객체, 예시) 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨

    // 클래스 의존 관계
    // MemberService -> MemberRepository(Interface)
    // MemberRepository(Memory) -> MemberRepository(Interface)

    // 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계
    // 데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정
    // 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용

    // 이 때 리포지토리를 인터페이스로 사용하는 건 아직 저장소를 어떤 것으로 쓸 지 정하지 못했기 때문이다.
}
