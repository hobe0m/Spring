package org.choongang.controllers.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j // 꼭 lombok쪽에 있는 것을 써야 log가 알아서 생성된다.
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/join")
    public String join() {
        log.info("로그 메세지!");
        log.info("로그 {}, {}", "값1", "값2"); // { 치환되는 내용 }, 중괄호는 치환되는 내용들을 적어주면 된다.
                                             // 첫 번째 중괄호에 값1이 두 번째 중괄호에 값2가 치환돼서 들어간다.
        return "member/join";
    }
}
