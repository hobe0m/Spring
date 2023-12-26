package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 공통 속성화

@MappedSuperclass // 공통 속성화를 위해 만들어진 클래스임을 알린다.
@EntityListeners(AuditingEntityListener.class) // @MappedSuperclass의 활성화가 목적
@Getter
@Setter
public abstract class Base {
    // 공통으로 쓸 엔티티들 모음
    // 객체를 만들지 않고 다른 테이블이 공유하기 위해 만들어짐
    // 상속을 위해 만들어진 것이므로 객체를 만들지 못하게 통제
    // 추상클래스로 만든다.

    @CreatedDate
    @Column(updatable = false) // 추가만 가능, 수정 불가
    private LocalDateTime createdAt; // 처음 추가될 때만 값이 들어가야 한다.

    @LastModifiedDate
    @Column(insertable = false) // 수정만 가능, 추가 불가
    private LocalDateTime modifiedAt; // 수정될 때만 값이 들어가야 한다.
}
