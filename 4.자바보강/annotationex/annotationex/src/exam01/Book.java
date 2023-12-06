package exam01;

public class Book {
    private String title;

    @Override // 재정의 된 메소드를 알려주는 Annotation
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
