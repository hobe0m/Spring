package Hello.hello.spring.repository;

import Hello.hello.spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제(여러 군데에서 한번에 접근)가 있을 수 있어 Concurrent HashMap를 사용해야 한다.
    //  - Concurrent HashMap : 멀티스레드 환경에서 안전하게 사용할 수 있도록 설계된 해시맵

    // store라는 이름의 Map 타입 변수 선언
    // Long 타입의 키와 Member 타입의 값을 갖고, HashMap의 인스턴스로 초기화
    // 각 Member는 고유한 Long 타입의 키를 통해 접근할 수 있다.
    private static Map<Long, Member> store = new HashMap<>();

    // sequence라는 long 타입 변수 선언
    // 초기값은 0L, 새로운 Member 객체를 생성할 때 고유한 ID를 생성하는데 사용
    // 실무에서는 동시성 문제를 고려해 AtomicLong을 사용해야 한다.
    //  - AtomicLong : 원자적 방식으로 연산을 수행해 특정 작업이 중단되지 않고 단일 단계로 완료된다.
    //   - 즉, 작업이 실행되면 다른 스레드나 프로세스에 의해 방해받지 않고 반드시 끝까지 실행된다.
    //   - 따라서 데이터 일관성이 유지된다.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    // 멤버 객체를 받아 sequence를 1 증가 시켜 id에 저장하고, store에 member 객체를 저장한다.
    // store라는 Map이 Long 타입으로 구분하기 때문에 getId로 id를 불러오고 그에 맞는 member에 저장한다.
    // name은 요청 받기 때문에 다루지 않아도 된다.

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 주어진 id에 해당하는 Member 객체를 찾고 그 결과를 Optional로 감싸서 반환
    // Optional로 감싸면 호출하는 쪽에서 객체의 존재 유무를 쉽게 체크할 수 있어 가독성을 높인다.

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    // 주어진 name에 해당하는 Member 객체를 찾고 그 결과를 Optional로 감싸서 반환
    // stream()을 사용해 데이터 컬렉션을 효과적으로 처리, 지연 평가과 중간 및 최종 연산을 통해 필요할 때만 연산 수행
    // 원본 데이터를 변경하지 않고 새로운 결과 생성, 병렬 처리 기능을 통해 성능 향상
    // 또한 filter를 사용하기에도 좋은 상태로 변환
    // member.getName().equals(name) 즉, 이름이 name과 같은 멤버를 찾아 반환한다.
    //  - 이 때 없으면 Optional로 감싸서 반환

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

    // map 형태를 List 형태로 출력
    // 새로운 리스트를 생성한 뒤 store의 전체 데이터인 values()를 넣어 반환한다.
    // 조회 시 순서 유지, 순회 및 반복, 유연한 연산, 인덱스 기반 접근 등의 장점이 있어 List 형태로 출력한다.

    // 테스트 케이스를 작성해 검증한다.

    // 회원 리포지토리 테스트 케이스 작성
    // 개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 어플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다.
    // 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행과 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다.
    // 따라서 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.

    //  - JUnit : Java 언어를 위한 단위 테스트 프레임 워크
    //   - 즉, Java로 짜여진 프로그램의 기능을 테스트하기 위해 사용하는 것

    //  - 프레임워크(FrameWork) : 특정 프로그래밍 언어나 플랫폼에서 애플리케이션을 개발하는 데 도움을 주는 구조와 도구의 집합
    //   - 프레임 워크는 구조 제공, 제어의 역전, 포괄적인 기능
    //   - 라이브러리는 기능 제공, 제어의 유지, 경량성
    //   - 라이브러리나, 프레임워크는 의존성을 추가해서 사용한다.
}
