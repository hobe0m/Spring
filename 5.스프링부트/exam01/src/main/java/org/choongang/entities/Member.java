package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
// 기본 제한자만 설정하고 싶은데 안될 때(Builder 사용 시)
// 두 가지 Annotaion(NoArgsConstructor AllArgsConstructor)을 쓰면 해결된다.
public class Member {
    // USER_NO -> 카멜 표기법으로 userNo로 사용하면 된다.
    @Id // 기본 키(primary key)를 알려주는 Annotation
    private long userNo;
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;

}
