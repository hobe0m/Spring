package controllers.member;

import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
    private String email;
    private List<String> hobby;
    private boolean agree;
}
