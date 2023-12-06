package exam01;

public class Ex04 {
    // 리터럴 상수, 동일한 주소에 숫자 하나(메모리 낭비 방지)
    public static void main(String[] args) {
        Integer num1 = Integer.valueOf (1000000);
        Integer num2 = Integer.valueOf (1000000);

        System.out.println(num1 == num2);
        System.out.println("num1 = " + System.identityHashCode(num1));
        System.out.println("num2 = " + System.identityHashCode(num2));
        // long num2 = num1.longValue()
    }
}
