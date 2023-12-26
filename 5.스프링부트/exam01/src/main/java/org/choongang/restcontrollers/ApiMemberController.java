package org.choongang.restcontrollers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.choongang.commons.BadRequestException;
import org.choongang.commons.JSONData;
import org.choongang.entities.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class ApiMemberController {

    @PostMapping
    public ResponseEntity<JSONData> join(@Valid @RequestBody  RequestJoin form, Errors errors) {
        if (errors.hasErrors()) {
            List<String> messages = errors.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            log.info("에러 : {}", messages.toString());

            String message = messages.stream().collect(Collectors.joining(","));

            throw new BadRequestException(message);
        }

        // 응답 코드 - 201, Body - 없음

        HttpStatus status = HttpStatus.CREATED;
        JSONData<Object> data = new JSONData<>();
        data.setStatus(status);

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
        /*
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("CUSTOM_HEADER", "value1")
                .build();

         */
    }

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

        //JSONData<Member> data = new JSONData<>();
        //data.setData(member);

        //return new JSONData<>(member);
        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
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

    @GetMapping("/message")
    public String message() {

        return "안녕하세요!";
    }

    @GetMapping("/process")
    public void process() {
        System.out.println("처리....");
    }

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity errorHandler(Exception e) {


       // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }*/
}