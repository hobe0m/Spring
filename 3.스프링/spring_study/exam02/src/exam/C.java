package exam;

public class C extends B{
    int numC = 30;

    // 기본 생성자는 따로 생성하지 않아도 다른 생성자를 만들지 않았다면 자동으로 만들어진다.
    public C() {
        super(); // B()를 의미
        System.out.println("C 생성자!");
    }
}
