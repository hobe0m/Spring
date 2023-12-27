package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByUserId(String userId);

    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2);

    Page<Member> findByUserNmContaining(String key, Pageable pageable);


    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE '%:key1%' OR USER_ID LIKE '%:key2%' ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("key1") String keyword1, @Param("key2") String keyword2);
}