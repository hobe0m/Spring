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
public class JdbcEx01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MemberRepository repository;

    @Test
    void test1() {
        List<Member> members = (List<Member>)repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        Member member = repository.findById(18L).orElse(null);

        member.setUserNm("(수정)사용자01");
        member.setModDt(LocalDateTime.now());

        repository.save(member);
    }

    @Test
    void test3() {
        Member member = repository.findByUserId("user01");
        log.info(member.toString());
    }

    @Test
    void test4() {
        List<Member> members = repository.findByUserNmContainingOrUserIdContainingOrderByRegDtDesc("용", "Id");
        members.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<Member> members = repository.getMembers("용", "Id");
        members.forEach(System.out::println);
    }

    @Test
    void test6() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(desc("regDt"),asc("userId")));
        Page<Member> data = repository.findByUserNmContaining("용", pageable);

        List<Member> members = data.getContent();
        long total = data.getTotalElements();
        int totalPages = data.getTotalPages();


    }
}