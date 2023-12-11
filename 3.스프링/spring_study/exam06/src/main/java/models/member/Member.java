package models.member;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private LocalDateTime regDt;

}
