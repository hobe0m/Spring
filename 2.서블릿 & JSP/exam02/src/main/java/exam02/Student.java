package exam02;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String subject;

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        // 인스턴스의 자원 = 지역변수의 자원
        // this가 붙으면 인스턴스의 자원이라는 뜻
        // 애매하지 않으면 this를 사용하지 않는다.

    }

    // ChatGPT 답변
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student)obj;
        if(id == s2.id && name.equals(s2.name) && subject.equals(s2.subject)){
            return true;
        }

        return false;
    }

    public int hashCode() {
        return Objects.hash(id, name, subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
