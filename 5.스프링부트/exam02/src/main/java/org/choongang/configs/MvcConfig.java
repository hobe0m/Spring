package org.choongang.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing // @EntityListeners 이벤트 리스너를 활성화 시키기 위해 설정
public class MvcConfig implements WebMvcConfigurer {

}
