package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<Member>, RequiredValidator {
    // RequiredValidator : 필수 항목 검증

    // Java에서는 상속보다는 하나의 구성요소로 확장하는 것을 더 선호한다.
    // 상속은 최대한 마지막에 실시(한 번밖에 하지 못하고, 꼭 필요한 것만 들어 있는 것이 아니기 때문에)

    @Autowired
    private MemberDao memberDao;

    public void validate(Member member) {
        // 전달받은 객체인 Member member를 검증
        /* 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명 */
        
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();
    
        // 필수 항목은 - null 또는 빈 공백 문자 "    "( isBlank() 사용 )
       checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
       checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
       checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
       checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

       // 아이디가 이미 등록되어 있는지 체크
       // memberDao가 있어야 checkFalse를 실행할 수 있으므로, 의존 관계라고 할 수 있다.
       checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디 입니다."));

       // 비밀번호, 비밀번호 확인의 일치 여부 체크
       checkTrue(userPw.equals(confirmPw), new BadRequestException("비밀번호가 일치하지 않습니다."));
       }
    }


