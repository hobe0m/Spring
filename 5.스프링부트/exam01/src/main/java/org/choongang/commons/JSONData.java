package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData<T> {
    private boolean success = true;
    private HttpStatus status = HttpStatus.OK; // 응답 상태 코드

    @NonNull
    private T data; // 성공시 Body 데이터
    private String message; // 실패시 메세지
}