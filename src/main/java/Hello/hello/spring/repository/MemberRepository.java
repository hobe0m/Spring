package Hello.hello.spring.repository;

import Hello.hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 저장
    Member save(Member member);
    
    // 조회
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
