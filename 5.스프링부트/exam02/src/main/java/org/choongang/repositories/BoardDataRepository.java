package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>,
                                            QuerydslPredicateExecutor<BoardData> {
    List<BoardData> findBySubjectContaining(String keyword);
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);

    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE '%:key%' ORDER BY b.seq DESC")
    List<BoardData> getSubjects(@Param("key") String keyword);

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key%")
    Page<BoardData> getSubjects(@Param("key") String keyword, Pageable pageable);
}
