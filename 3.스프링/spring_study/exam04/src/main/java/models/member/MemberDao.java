package models.member;

import config.ManualBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDao { // Bean의 이름 : memberDao
    private static Map<String, Member> members = new HashMap<>();
    public void register(Member member) {
        members.put(member.getUserId(), member);
    }
    
    public boolean exists(String userId) {
        return members.containsKey(userId); // userId가 포함 되어 있는 지를 확인
    }

    public List<Member> getList() {
        return new ArrayList<>(members.values()); // 회원 데이터 목록 수집
    }
}

