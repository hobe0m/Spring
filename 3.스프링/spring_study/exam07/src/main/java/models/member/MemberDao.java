package models.member;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor // @Autowired 대신 사용, 대신 final(상수, 한번 만들면 바꿀 수 없다)을 붙여주어야 한다
public class MemberDao {

    private final MemberMapper mapper;

    public boolean register(Member member) {

        int affectedRows = mapper.register(member);

        return affectedRows > 0;
    }

    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0; // 1 이상이면 이미 등록된 아이디라는 의미, 중복된 아이디 체크
    }

    public Member get(String userId) {
        return mapper.get(userId);
    }
}
