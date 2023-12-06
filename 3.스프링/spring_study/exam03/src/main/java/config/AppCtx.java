package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator(memberDao());
    }

    @Bean
    public JoinService joinService() {
        return new JoinService(memberDao(), joinValidator());
    }

    @Bean
    public ListService listService() {
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
