package Hello.hello.spring.service;

import Hello.hello.spring.domain.Member;
import Hello.hello.spring.repository.MemberRepository;
import Hello.hello.spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 테스트 후 RollBack 실행
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService; // 테스트니까 바로 필드 기반으로 주입해준다.
    @Autowired MemberRepository memberRepository;


    @Test
    void join() {
        Member member = new Member();
        member.setName("user1");

        Long saveId = memberService.join(member);

        Member findMember = memberService.findOne(saveId).get();

        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void DuplicationMemberException() {

        Member member1 = new Member();
        member1.setName("user");

        Member member2 = new Member();
        member2.setName("user");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    // @SpringBootTest : 스프링 컨테이너와 테스트를 함께 진행한다.
    // @Transactional : 테스트 시작 전 트랜잭션 시작 후 완료 시 롤백한다.
    // 단위테스트와 통합테스트로 구분하면 된다.
    // 순수한 단위 테스트가 훨씬 좋은 테스트일 확률이 높다.
}