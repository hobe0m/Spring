package exam;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C();

        A a = new D();
    if(a instanceof C) { // 확인하려는 객체 instanceof 비교대상이 되는 클래스
        C c2 = (C) a;
        // c2가 더 큰 값이므로 c2에 a를 담으면 손실이 발생하기 때문에, 강제 형변환을 해주어야 한다.
        }
    }
}
