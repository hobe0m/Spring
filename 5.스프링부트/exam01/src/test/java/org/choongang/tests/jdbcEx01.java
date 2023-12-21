package org.choongang.tests;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@Slf4j
@SpringBootTest
public class jdbcEx01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        List<Member> members = (List<Member>)repository.findAll(); // SELECT 쿼리 생성, 메소드가 다 구현이 되어 있기 때문
        members.forEach(System.out::println); // 멤버 하나하나를 출력
    }
    @Test
    void test2() {
        Member member = repository.findById(43L).orElse(null);
        // SELECT 쿼리가 날아가고 그 다음에 UPDATE 쿼리가 날아간다.
        member.setUserNm("(수정)사용자01");
        member.setModDt(LocalDateTime.now());

        repository.save(member); 
        // 일련의 과정을 통해 쿼리를 쓰지 않아도 알아서 INSERT가 된다.



    }
    // userId만을 조회하는 쿼리 생성
    @Test
    void test3() {
        Member member = repository.findByUserId("user01");
        log.info(member.toString()); // 문자열만 가능하기 때문에 toString()을 넣어준다.
    }

    @Test
    void test4() {
        List<Member> members = repository.findByUserNmContainingOrUserIdContainingOrderByRegDtDesc("용", "Id");
        // userNm에 용이 포함되어 있는 것을 찾는다.
        members.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<Member> members = repository.getMembers("용", "Id");
        members.forEach(System.out::println);
    }

    @Test
    void test6() {
        Pageable pageable = PageRequest.of(3, 10, Sort.by(desc("regDt"),
                asc("userId"))); // 0번부터 시작 즉, 0번이 1번
        Page<Member> data = repository.findByUserNmContaining("용", pageable);

        List<Member> members = data.getContent();
        long total = data.getTotalElements();
        int totalPages = data.getTotalPages();

    }
}
