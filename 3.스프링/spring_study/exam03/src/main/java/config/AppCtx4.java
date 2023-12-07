package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("models")
// models 내부에 있는 것들은 모두 스캔 후 필요한 빈을 알려주면 컨테이너 안에 생성
public class AppCtx4 {
}
