package exam05;

public interface Calculator { // 용도가 설계인 클래스의 일종이라고 생각해도 된다.
    int num = 10; // public static final
    int add(int num1, int num2); // public abstract가 필수(생략도 가능하지만, 이외의 것은 못쓴다.)
    // 추상메소드는 목적이 두 개이기 때문에, 위와 같은 코드를 사용하면 에러가 발생
    // 인터페이스는 목적(추상메소드)이 명확하기 때문에 위와 같은 코드를 사용해도 에러가 발생하지 않는다.
    // 따라서 구현체를 넣게 되면 에러가 발생한다.

    default int minus(int num1, int num2) {
        return num1 - num2;
    }



}
