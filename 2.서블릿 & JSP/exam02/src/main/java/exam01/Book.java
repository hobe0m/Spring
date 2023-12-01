package exam01;

import lombok.*;

// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
// @AllArgsConstructor // 모든 멤버 변수 초기화 생성자
// @NoArgsConstructor(access = AccessLevel.PRIVATE) // 기본 생성자
// @RequiredArgsConstructor

@Data // @Getter @Setter @ToString @EqualsAndHashCode가 한번에 정의된다.

public class Book {
    private String title;
    private String author;
    private String publisher;

    @Override
    public String toString() {
        return super.toString();
    }

}
