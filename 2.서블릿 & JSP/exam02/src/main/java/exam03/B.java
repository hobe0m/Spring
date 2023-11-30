package exam03;

public class B extends A {
    int numB = 20;

    public B() {
        super(); // 부모 클래스의 기본 생성자 추가, 따라서 A()가 생성된다.
        System.out.println("B 생성자!");
    }
}
