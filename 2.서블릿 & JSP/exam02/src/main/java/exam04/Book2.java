package exam04;

// lombok을 이용하면 더 편하게 사용할 수 있다.

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder @ToString
public class Book2 {
    private String title;
    private String author;
    private String publisher;

}
