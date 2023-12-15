package controllers.member;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join") // /member/join
    public String join(Model model) {


        model.addAttribute("pageTitle", "회원가입");

        return "member/join";
    }


    @PostMapping("/join") // /member/join
    public String joinPs(RequestJoin form) {
        System.out.println(form);

        return "member/join";
    }


    @GetMapping("/login") // /member/login
    public String login() {

        return "member/login";
    }

    @PostMapping("/login") // /member/login
    public String loginPs(RequestLogin form) {

        System.out.println(form);

        return "member/login";
    }

    @GetMapping("/list") // /member/list
    public String members(Model model) {

        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" + i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }

        model.addAttribute("members", members);

        return "member/list";
    }
}