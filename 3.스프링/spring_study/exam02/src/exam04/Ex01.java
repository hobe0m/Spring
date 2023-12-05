package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator();
        int result = cal.add(10, 20);
        System.out.println(result);
        System.out.println(cal.num);

        // Carculator.num = 20;

        // SimpleCalculator 안에 Calculator가 속해있다.
    }
}
