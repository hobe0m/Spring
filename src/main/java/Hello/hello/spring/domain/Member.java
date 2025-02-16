package Hello.hello.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    // ORM : Object Relational Mapping
    //  - 객체와 관계형 데이터베이스를 자동으로 매핑해주는 것, 즉 SQL 쿼리없이 데이터를 데이터베이스에 저장하고 관리할 수 있게 해주는 것

    // 고객이 정하는 것이 아닌, 시스템이 정하는 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY : DB가 값을 자동으로 지정해서 넣어주는 것, 아이덴티티 전략이라고도 부른다.
    private Long id;

    // 이름
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
