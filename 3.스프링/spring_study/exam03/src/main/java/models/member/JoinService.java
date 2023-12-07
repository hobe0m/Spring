package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class JoinService {


    @Autowired
    // @Qualifier :
    //      의존 주입 시 2가지 이상의 객체가 존재할 경우 빈의 이름을 지정하여 혼선을 없앤다.
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
