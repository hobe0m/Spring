package org.choongang.restcontrollers;

import org.choongang.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/member")
public class ApiMemberController {
    @GetMapping
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userPw("12345678")
                .userId("user01")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build();

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1,10)
                .mapToObj(i -> Member.builder()
                        .userNo(Long.valueOf(i))
                        .userId("user" + i)
                        .userPw("12345678")
                        .userNm("사용자" + i)
                        .email("user" + i + "@test.org")
                        .regDt(LocalDateTime.now())
                        .modDt(LocalDateTime.now())
                        .build()
                ).toList();

        return members;
    }

    // 문자열 매핑 후 출력, RestController에서 가능(바디쪽의 출력 결과물이 나온다 - ResponseBody 사용)
    @GetMapping("/message")
    public String message() {
        
        
        return "안녕하세요!";
    }

    @GetMapping("/process")
    public void process() {
        System.out.println("처리....");
    }
}