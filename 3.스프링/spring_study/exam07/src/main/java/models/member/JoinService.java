package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberDao memberDao;

    public void join(RequestJoin form) {

        String hash = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(12));
        // gensalt : 해시의 반복 횟수, 횟수가 많아질수록 보안은 강해지지만, 속도는 느려진다.

        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}
