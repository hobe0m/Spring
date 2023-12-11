package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 설정 클래스임을 알려주는 애노테이션
@Import(DbConfig.class) // DbConfig의 클래스를 포함
public class AppCtx {

}
