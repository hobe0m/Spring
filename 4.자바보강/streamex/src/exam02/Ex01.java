package exam02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // 기본형은 안되고 무조건 클래스 형태로 넣어야 하기 때문에 int는 안되고 Integer만 가능

        IntSummaryStatistics stat = nums.stream().mapToInt(x -> x).summaryStatistics();

        long sum = stat.getSum();
        double avg = stat.getAverage();
        long count = stat.getCount();
        int max = stat.getMax();
        int min = stat.getMin();

        System.out.printf("sum=%d, avg=%.2f, count=%d, max=%d, min=%d",
                sum, avg, count, max, min);
    }
}
