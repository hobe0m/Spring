package exam05;

import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        // int[] nums = {10, 3, 5, 33, 19, 25};
        // Arrays.sort(nums); // Comparable 기본 정렬 기준 - 오름 차순

        Integer[] nums = {10, 3, 5, 33, 19, 25};
        Arrays.sort(nums, Comparator.reverseOrder()); // Comparator - 내림 차순

        System.out.println(Arrays.toString(nums));
    }
}
