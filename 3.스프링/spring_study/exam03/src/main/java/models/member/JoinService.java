package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.Validator;

public class JoinService {

    @Autowired
    @Qualifier("memberDao")
    private MemberDao memberDao;
    @Autowired
    private JoinValidator validator;
    public JoinService() {}

    public JoinService(MemberDao memberDao, JoinValidator validator) {
        this.memberDao = memberDao;
        this.validator = validator;
    }


    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
