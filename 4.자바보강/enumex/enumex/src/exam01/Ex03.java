package exam01;

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(Transportation.BUS instanceof Transportation);
        // BUS도 Enum상수 클래스(Transportation)의 객체이다.

       int totalFare = Transportation.BUS.getTotal(10);
       System.out.println(totalFare);
    }
}
