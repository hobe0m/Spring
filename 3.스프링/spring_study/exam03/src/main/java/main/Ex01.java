package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import config.AppCtx4;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx3.class);

        JoinService joinService = ctx.getBean(JoinService.class);
        // JoinService(매개변수)가 하나밖에 없으므로, 찾는데 무리가 없어 이름을 명시하지 않고 클래스만 넣어주면 된다.
        ListService listService = ctx.getBean(ListService.class);
        // ListService(매개변수)가 하나밖에 없으므로, 찾는데 무리가 없어 이름을 명시하지 않고 클래스만 넣어주면 된다.

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();
    }
}
