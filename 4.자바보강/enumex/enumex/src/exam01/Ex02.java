package exam01;

public class Ex02 {
    public static void main(String[] args) {
        String str = "TAXI";

        Transportation trans = Enum.valueOf(Transportation.class, str);
        System.out.println(trans);
        // trans가 Enum 상수로 바뀌어 있다.

        // trans와 동일 - valueOf()를 컴파일러가 자동으로 추가해주므로 좀 더 편리하게 쓸 수 있다.
        Transportation trans2 = Transportation.valueOf(str);
        System.out.println(trans == trans2);
        // 상수이므로 어떤 변수에 넣어도 동일하다.
    }
}
