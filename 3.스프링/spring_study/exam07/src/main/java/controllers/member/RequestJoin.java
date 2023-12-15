package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    @NotBlank
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String userPw;

    @NotBlank
    private String confirmPw;

    @NotBlank
    private String userNm;

    @Email
    private String email;

    @AssertTrue
    private boolean agree;



    private List<String> hobby; // String[] hobby; Set<String> hobby;
    private Address addr; // 중첩된 커맨드 객체
}
