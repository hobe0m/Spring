package exam01;

public class Student {
    int id;
    String name;
    String subject;

    public Student() {}
    // 멤버 변수의 초기화 작업을 주로 진행

    void showInfo() {
        System.out.printf("id=%d, name=%s, subject=%s", id, name, subject);
    }
}
