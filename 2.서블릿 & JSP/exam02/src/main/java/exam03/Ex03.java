package exam03;

public class Ex03 {
    public static void main(String[] args) {
        A a1 = new C(); // A가 C안에 포함되어 있으므로 가능

        A a2 = new D(); // A가 D안에 포함되어 있으므로 가능

        if (a2 instanceof C) {
            C c1 = (C) a2;
        }
        // 참조 변수 instanceof 클래스
        // 변수에 있는 객체가 클래스에 있는 객체인 지 확인하는 것
        // 객체의 출처를 체크
        // 같은 출처라면 true 아니라면 false
    }
}
