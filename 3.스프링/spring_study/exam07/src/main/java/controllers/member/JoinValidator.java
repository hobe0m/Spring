package controllers.member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {
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



    }
}
