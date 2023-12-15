package controllers.member;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("자바", "오라클", "JSP", "스프링");
    }

    @GetMapping("/join") // /member/join
    public String join(@ModelAttribute RequestJoin form, Model model) {

        //model.addAttribute("requestJoin", new RequestJoin());
        model.addAttribute("pageTitle", "회원가입");

        return "member/join";
    }


    @PostMapping("/join") // /member/join
    public String joinPs(RequestJoin form, Model model) {



        // System.out.println(form);
        // 커맨드 객체 RequestJoin  -> requestJoin 이름으로 속성이 추가 -> 템플릿 내에서 바로 접근 가능
        // response.sendRedirect(request.getContextPath() + "/member/login")

        return "forward:/member/login";
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