package exam03;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C(); // C -> C, B, A 모두 될 수 있다.
                       // 이것을 다형성이라고 한다.

        A a = c; // 출처가 C이므로 가능
        B b = c; // 출처가 C이므로 가능

        A aa = new C();

        // 오렌지 주스를 가장 큰 컵인 C에 넣고 그 안에 중간 크기의 컵 B를 넣고 마지막으로 가장
        // 작은 크기의 컵 A를 넣으면 A와 B에는 자연스럽게 오렌지 주스가 있다는 것을 알 수 있다.

    }
}
