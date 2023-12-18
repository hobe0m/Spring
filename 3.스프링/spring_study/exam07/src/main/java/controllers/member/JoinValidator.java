package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) { // 검증 커맨드 객체를 제한(타게팅)
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     *
     * @param target the object that is to be validated // 검증할 커맨드 객체
     * @param errors contextual state about the validation process // 검증 실패 시 에러 정보를 처리하는 메소드
     */

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 필수 항목 검증(userId, userPw, confirmNm, agree) - O
         * 2. 중복 아이디 여부 체크
         * 3. 아이디 최소 자릿수(6자리 이상) 체크 - O
         * 4. 비밀번호 최소 자릿수(8자리 이상) 체크 - O
         * 5. 이메일 값은 필수는 아니지만 값이 있으면 형식 체크 - O
         * 6. 비밀번호와 비밀번호 확인 일치 여부
         */

        RequestJoin form = (RequestJoin)target;

        // 중복 아이디 여부 체그
        String userId = form.getUserId();
        if (StringUtils.hasText(userId) && memberDao.exist(userId)) { // 이미 가입된 아이디 인지 확인

            errors.rejectValue("userId", "Duplicated");
        }

        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();

        if(StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw) && !userPw.equals(confirmPw)) {
            errors.rejectValue("confirmPw", "Mismatch");
        }

        boolean result = false;
        if (!result) {
            errors.reject("ErrorTest", "공통에러...");
        }
    }
}
