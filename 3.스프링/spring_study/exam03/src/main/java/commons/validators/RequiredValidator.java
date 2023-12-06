package commons.validators;

import org.springframework.util.StringUtils;

public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        // null 값이거나, 값이 없을 때 예외가 발생한다.
        if(!StringUtils.hasText(str)) {
            throw e;
        }
    }

    // 참이 아닐 때, 예외가 발생한다.
    default void checkTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e;
        }
    }
    // 참일 때, 예외가 발생한다.
    default void checkFalse(boolean result, RuntimeException e) {
        if (result) {
            throw e;
        }
    }
}
