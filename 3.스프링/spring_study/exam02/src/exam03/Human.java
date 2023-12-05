package exam03;

public class Human extends Animal{
    // 하위 클래스는 상위 클래스의 내용을 조금 더 구체화 한다.
    // ex) 상위 클래스 : 움직인다, 하위 클래스 : 뛰어다닌다. 먹는다
    @Override
    public void move() {
        System.out.println("두 발로 직립보행한다.");
    }
    public void readBook() {
        System.out.println("독서를 한다.");
    }
}

