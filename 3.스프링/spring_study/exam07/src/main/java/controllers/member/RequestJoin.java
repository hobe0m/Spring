package controllers.member;

import lombok.Data;

@Data
public class RequestJoin {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
    private String email;

    private boolean agree;
}
