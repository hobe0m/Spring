package tests;

import configs.DbConfig;
import configs.MvcConfig;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.xml.crypto.Data;
import java.sql.Connection;

@SpringJUnitConfig
@ContextConfiguration(classes = DbConfig.class)
public class JoinServiceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest() {
        try (Connection conn = dataSource.getConnection()) {
                System.out.println(conn);
            } catch(Exception e) {
                e.printStackTrace();
        }
    }
}
