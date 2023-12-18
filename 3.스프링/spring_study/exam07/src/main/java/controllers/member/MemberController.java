package controllers.member;

/* 양식을 보여주는 페이지 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService; // 회원가입 처리 마무린

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
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {
        // 커맨드 객체 바로 뒤에 에러가 위치 해야 한다.
        // 그래야 검증하고 바로 실패 메세지를 보낼 수 있다.


        joinValidator.validate(form, errors);

        if (errors.hasErrors()) { // 검증 실패시

            return "member/join";
        }

        // 회원 가입 처리
        joinService.join(form);

        // 커맨객체 RequestJoin  -> requestJoin 이름으로 속성이 추가 -> 템플릿 내에서 바로 접근 가능
        // response.sendRedirect(request.getContextPath() + "/member/login")
        // Location: 주소
        return "redirect:/member/login";

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
    /*
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }
    */
}