package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberDao memberDao;

    public void join(RequestJoin form) {
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(form.getUserPw())
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}
