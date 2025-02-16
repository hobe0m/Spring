package Hello.hello.spring.service;

import Hello.hello.spring.domain.Member;
import Hello.hello.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Ctrl + shift + T : 테스트 클래스 생성

@Transactional
// JPA는 join(회원가입) 시 모든 데이터 변경이 Transaction 안에서 실행이 되어야 한다.
public class MemberService {

    // 서비스 클래스는 비즈니스에 가까운 용어를 사용해야 한다.
    // 기획자와 개발자가 둘 다 공통으로 사용하는 용어를 쓰기 때문이다.
    // 반면에 리포지토리는 좀 더 개발자 친화적인 용어를 사용한다.

    // 서비스는 리포지토리와 연동되어야 하므로 리포지토리 사용
    private final MemberRepository memberRepository;

    // 여기도 마찬가지로, MemberService를 생성할 때 MemoryMemberRepository를 넣어준다.
    // MemberRepository가 아닌 이유는, MemoryMemberRepository가 구현체이기 때문이다.

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름이 있을 경우 생성 X, 중복 불가
        // 이 때, Optional을 바로 반환하는 것은 권장되는 방법이 아니기 때문에 ifPresent와 붙여서 사용하는 것이 좋다.
        //  - 직접 값을 꺼내는 경우 값이 없을 때 NoSuchElementException이 발생할 수 있다.
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result는 이미 나왔으므로 바로 .ifPrensent와 연결시켜준다.

        // Ctrl + Alt + M : 메서드 추출
        // 만든 메서드를 추출해서 빼낸다.
        // 중복 회원 검증
        validateDuplicateMember(member); 
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
        // Optional로 감쌌기 때문에 ifPresent 사용 가능, 감싸지 않았다면 if를 사용해서 검증
        // 즉, Optional의 메서드들을 사용하는 것이다.

        // m 즉, 중복되는 member 객체가 있으면 "이미 존재하는 회원입니다."를 출력
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
