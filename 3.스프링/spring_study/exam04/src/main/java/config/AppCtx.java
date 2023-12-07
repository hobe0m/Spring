package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
// 검색 범위 : models와 models의 하위 패키지를 모두 포함

/* @ComponentScan(value = "models", excludeFilters =
               // @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = ManualBean.class))
*/
/*
@ComponentScan(value = "models", excludeFilters =
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ManualBean.class))
*/
// class가 여러 개라면 {}안에 ,를 활용해서 적어주면 된다.
@ComponentScan(value = "models", excludeFilters =
                @ComponentScan.Filter(type=FilterType.ASPECTJ, pattern = "models..*Dao"))
// 점 한 개일 때는 하위 클래스, 두 개일 때는 하위클래스가 포함한 모든 클래스
// 다 추가하고 일부만 배제하는 것을 가장 많이 사용한다.
// 하지만 배제하는 경우는 많이 없다.


public class AppCtx {
    /*
    @Bean
    public MemberDao memberDao() { // 이름이 동일한 경우 수동 등록 빈이 자동 등록 빈보다 우선 순위가 높다.
        System.out.println("수동 등록 Bean입니다.");
        return new MemberDao();
    }
     */
}
