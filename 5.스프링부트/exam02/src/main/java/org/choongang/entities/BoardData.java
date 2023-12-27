package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BoardData extends Base {
    @Id
    @GeneratedValue
    private Long seq;

    @Column(length=100, nullable = false)
    public String subject;

    @Lob
    @Column(nullable = false)
    public String content;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 명시, 알아서 조인된다.
    @JoinColumn(name="userNo") //  @JoinColunm : 외래키로 설정되는 필드명을 직접 설정
    private Member member; // 다른 엔티티에 설정된 키본키가 외래키로 설정된다.

    @ManyToMany(fetch = FetchType.LAZY)
    private List<HashTag> tags = new ArrayList<>();


}
