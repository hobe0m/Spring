package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListService {

    private MemberDao memberDao;

    @Autowired // 생성자 위가 아니라, Setter 위에다가 넣어도 된다.
               // setter 메소드가 호출될 때 의존성이 주입된 상태로 호출된다.
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.getList();
        for(Member member : members) {
            System.out.println(member);
        }

    }
}
