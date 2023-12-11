package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration // 설정 파일임을 알려주는 애노테이션
public class DbConfig {

    // 연결 객체를 만들 수 있는 데이터소스 객체 생성
    // 외부에서 제공받는 클래스에는 인터페이스를 추가하지 못한다.
    @Bean(destroyMethod = "close") // destroyMethod를 통해 자원 해제
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("SPRING6");
        ds.setPassword("_aA123456");

        // 커넥션 풀 설정
        ds.setInitialSize(2);
        ds.setTestWhileIdle(true); // 유휴 상태 커넥션 객체의 체크 여부
        ds.setTimeBetweenEvictionRunsMillis(3 * 1000); // Test에 대한 주기, 기본값은 5초, 단위가 밀리세컨드이므로 3초면 3000
        ds.setMinEvictableIdleTimeMillis(30 * 1000); // 유휴 시간이 지나고, 얼마 후에 소멸할 지 설정
                                                     // 현재 30초가 최대 유휴 시간으로 설정, 경과 시 소멸

        
        return ds;
    }
    @Bean // Spring의 관리 객체로 지정
    public JdbcTemplate jdbcTemplate() {


        return new JdbcTemplate(dataSource()); // dataSource를 주입받아서 사용한다.
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());

        return tm;
    }

}
