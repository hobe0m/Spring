package exam02;

public class Ex02 {
    public static void main(String[] args) {
        add(new Calculator() {

            public int add(int num1, int num2) {
                return num1 + num2;
            }
        });

        add((a,b) -> a + b);
    }

    public static void add(Calculator cal) {
        int result = cal.add(10,20);
        System.out.println(result);
    }
}
