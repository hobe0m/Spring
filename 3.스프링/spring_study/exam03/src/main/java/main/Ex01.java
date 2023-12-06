package main;

import config.AppCtx;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        ListService listService = ctx.getBean("listService", ListService.class);

        Member member = new Member();
        member.setUserId("userId");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();
    }
}
