package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data // getter, setter, toString을 사용할 수 있으면 좋기 때문에 때문에 지정
      // 데이터형 클래스이기 때문에 정의
@Entity // 엔티티로 인식하게 해주는 애노테이션
@Table(/* name="USERS", */ indexes = @Index(name="idx_member_createdAt",
                                        columnList = "createdAt DESC"))
                                    // 엔티티의 이름을 기준으로 사용한다
                                    // 반환값 : INDEX
                                    // name : index명
                                    // columnList : index를 사용할 컬럼명
                                    //              엔티티에 있는 속성명 사용해야 함
                                    // DESC : 내림차순(기본)

// @Table을 통해 테이블과 관련된 기본적인 설정을 한다
// @EntityListeners(AuditingEntityListener.class), Base를 상속(공유)해서 주석처리
// 엔티티의 변화를 감지할 수 있다.
// @CreatedDate, @LastModifiedDate를 사용하기 위해 설정
// 활성화 시켜야 사용 가능, choongang의 configs

public class Member extends Base{ // 클래스 이름이 테이블명의 기본 값, 지정하려면 @Table 사용
    @Id @GeneratedValue
    // 기본키 지정 애노테이션, 필수 없으면 오류(유일한 지 아닌지 구분해야 하기 때문에)
    // @GeneratedValue는 Oracle에서의 시퀀스, 자동증감번호
    private Long seq;

    @Column(length = 80, unique = true, nullable = false) // unique 제약조건(중복 X) 설정
    private String email;

    @Column(length = 40, nullable = false) // NotNull 추가
    private String name;

    @Column(length = 65, /* name="userPw", */ nullable = false) // 코드에서는 password를 사용해도 DB(테이블)에는 userPw로 설정된다.
    private String password; // varchar2

    // @Transient
    // @Lob
         // String일 때 @LOB을 사용하면 CLOB(Characetr Large Object) 형태로 나온다.
         // 내용이 많을 때 사용한다
    // private String introduction; // CLOB

    @Enumerated (EnumType.STRING)
    @Column(length = 10)
    // EnumType = ORDINAL, String으로 받을 수 있는데, 대부분 ORDINAL을 사용하지 않고 String을 사용한다.
    // ORDINAL 값 : 상수의 위치 번호, 순서대로 0,1...
    // 번호가 바뀜에 따라 기능이 달라질 수 있어 잘 쓰지 않는다.
    // 예시 : 매니저, 관리자, 일반 회원, 추가를 잘못하면 과거에 권한이 없던 회원이 관리자 권한을 가질 수 있게 된다
    private MemberType type;

    /*
    // @CreationTimestamp // INSERT SQL 실행 시, 날짜와 시간 기록
    @CreatedDate
    private LocalDateTime createdAt;
    // CreationTimestamp : INSERT 시간 시 시간 자동 저장, hibernate에서 제공하는 기능
    //  - table 기준
    // JPQL의 표준 : @CreatedDate, 엔티티의 값이 추가되었을 때
    //  - entity 기준

    // @UpdateTimestamp //  UPDATE SQL 실행 시, 날짜와 시간 기록
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    // UpdateTimestamp : UPDATE 시 시간 자동 저장, hibernate에서 제공하는 기능
    //  - table 기준
    // JPQL의 표준 : @LastModifiedDate, 엔티티의 값이 수정되었을 때
    //  - entity 기준
    */

    // @Transient : 엔티티 내부에서만 사용이 목적, DB에는 필드에는 반영 X

    // @Temporal(TemporalType.TIME) // 시간
    // @Temporal(TemporalType.DATE) // 날짜
    // @Temporal(TemporalType.TIMESTAMP) // 날짜 + 시간
    // public Date dt;
    // LocalDate, LocalTime, LocalDateTime으로 대체된다.

    @ToString.Exclude // toString 메소드에서 배제되어 순환참조오류 해결
    @OneToMany(mappedBy = "member", fetch=FetchType.EAGER)
    private List<BoardData> items = new ArrayList<>();

    // ManyToOne이 있어야 OneToMany가 있다.

    @OneToOne
    @JoinColumn(name = "addressNo")
    private Address address;
}
