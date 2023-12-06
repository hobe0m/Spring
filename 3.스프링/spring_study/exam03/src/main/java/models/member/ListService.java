package models.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListService {

    private MemberDao memberDao;

    @Autowired
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
