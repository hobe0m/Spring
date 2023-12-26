package org.choongang.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class Stat {

    //@Scheduled(cron="*/3 * * * * *") // 3초마다 실행
    //@Scheduled(fixedDelay = 3000) // 작업 완료 후 3초 지연
    //@Scheduled(initialDelay = 3, timeUnit = TimeUnit.SECONDS) // 작업 시작 전 3초 대기
    // @Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS) // 작업 시간 포함 3초 마다
    public void orderStatProcess() {
        log.info("주문 통계 진행....");
    }

}