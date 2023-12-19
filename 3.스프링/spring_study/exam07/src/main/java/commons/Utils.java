package commons;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {
    @Autowired
    private HttpSession session;

    public boolean isLogin() {
        return getMember() != null;
    }

    public Member getMember() {
        Member member = (Member)session.getAttribute("member");

        return member;
    }
}
