package Hello.hello.spring.domain;

public class Member {

    // 고객이 정하는 것이 아닌, 시스템이 정하는 id
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
