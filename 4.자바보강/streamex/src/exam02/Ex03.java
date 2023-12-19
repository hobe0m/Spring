package exam02;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i -> System.out.println("반복"));
        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total);
    }
}
