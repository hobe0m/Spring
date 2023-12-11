package exam04;

public class Student {
    static int id;
    String name;
    String subject;

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public static void staticMethod() {
        System.out.println("정적 메소드");
        id = 1000;
    }

    @Override
    public String toString() {
        //this
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
