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
    private List<String> hobby; // String[] hobby; Set<String> hobby;
    private Address addr; // 중첩된 커맨드 객체
    private boolean agree;
}
