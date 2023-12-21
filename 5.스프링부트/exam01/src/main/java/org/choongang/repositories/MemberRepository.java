package org.choongang.repositories;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByUserId(String userId); // userId를 통해 찾는다는 쿼리가 알아서 만들어진다.

    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2);
    // 추상메소드만 만들어도 구현체가 만들어진다.
    // OrderByRegDtDesc는 정렬, findByUserNmContaining는 00이 포함된 userNm, userId을 찾아라

    Page<Member> findByUserNmContaining(String key, Pageable pageable);


    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE '%:key1%' OR USER_ID LIKE '%key2%' ORDER BY REG_DT DESC"  )
    // 쿼리를 직접 사용할 수 있게 해주는 Annotation
    List<Member> getMembers(@Param("key1") String keyword1, @Param("key2") String keyword2);
    // key를 String keyword로 대체하겠다.
}
