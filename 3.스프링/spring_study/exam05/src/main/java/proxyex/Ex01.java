package proxyex;

public class Ex01 {
    public static void main(String[] args) {
        // 반복문 사용
        long stime = System.nanoTime(); // 공통 기능
        
        // 핵심 기능
        ImplCaculator cal1 = new ImplCaculator();
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1 : %d%n", result1);
        
        long etime = System.nanoTime(); // 공통 기능
        System.out.printf("걸린시간 : %d%n", etime - stime);

        // 자기 함수를 다시 끌어다 쓰는 재귀방식 사용

        stime = System.nanoTime(); // 공통 기능
        
        // 핵심 기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10L);
        System.out.printf("cal2 : %d%n", result2);
        
        etime = System.nanoTime(); // 공통 기능
        System.out.printf("걸린시간 : %d%n", etime - stime);
    }
}
