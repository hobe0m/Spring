package Hello.hello.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    // Around()로 범위 지정
    @Around("execution(* Hello.hello.spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toLongString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }

    // 회원 가입, 회원 조회 등 핵심 관심사항과 시간을 측정하는 공통 관심 사항을 분리하였다.
    // 시간을 측정하는 로직을 별도의 공통 로직으로 만들었다.
    // 핵심 관심 사항을 깔끔하게 유지보수 할 수 있다.
    // 변경이 필요하면 이 로직만 변경하면 된다.
    // 원하는 적용 대상을 선택할 수 있다.

    // AOP 동작 방식
    // 프록시라는 가짜 스프링 빈을 만들어 놓고, 가짜 스프링 빈이 끝나면 실제 스프링 빈을 호출한다.
    // 즉, controller - 가짜 스프링 bean(service) - 진짜 스프링 bean(service)로 연결
    // 이 때, joinPoint.proceed()가 사용된다.

    // 콘솔에 출력해서 확인할 수 있다.
}
