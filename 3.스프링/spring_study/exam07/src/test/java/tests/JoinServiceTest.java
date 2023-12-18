package tests;

import configs.ControllerConfig;
import configs.DbConfig;
import configs.MvcConfig;
import controllers.member.RequestJoin;
import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

// @SpringJUnitWebConfig
// @WebAppConfiguration
@Transactional // 테스트 한 데이터를 다시 되돌릴 때 사용(자동 RollBack)
@SpringJUnitConfig
@ContextConfiguration(classes = {DbConfig.class, ControllerConfig.class})
public class JoinServiceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private JoinService service;

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest() {
        try (Connection conn = dataSource.getConnection()) {
                System.out.println(conn);
            } catch(Exception e) {
                e.printStackTrace();
        }
    }

    @Test
    @DisplayName("MemberDao - exist 메소드 테스트")
    void existsTest() {
        String userId = "USER01";
        boolean result = memberDao.exist(userId);

        assertTrue(result);
    }
    @Test
    @DisplayName("JoinService - join 메소드 테스트")
    void JoinTest() {
        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test,org");

        service.join(form);

        Member member = memberDao.get(form.getUserId());

        System.out.println(member);
    }

}
