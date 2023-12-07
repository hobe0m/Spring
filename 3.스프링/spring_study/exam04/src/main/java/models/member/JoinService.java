package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Service
// 자동으로 등록한 Bean의 이름은 클래스의 이름이다. 첫 번째 글자가 대문자라면 소문자로 바뀐다. 따라서 joinservice
public class JoinService {


    private final MemberDao memberDao;
    // 초기화가 필요하기 때문에 자동으로 생성자 매개변수로 추가된다.

    @NonNull
    private final JoinValidator validator;
    // 초기화가 필요하기 때문에 자동으로 생성자 매개변수로 추가된다.

    // 기본 생성자가 아닌, 매개 변수를 가지는 생성자가 있을 때 자동으로 만들어준다.(Autowired가 필요없다.)
    // 자동으로 찾아서 객체 생성 후 의존성을 부여한다.

    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
