package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] nums2 = calc(nums, x -> x * x);

        /*
        int[] nums2 = calc(nums, new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }
        });

         */
        /*
        Calculator cal = new Calculator() {
            public int square(int num) {
                return num * num;
            }
        };

        int[] nums2 = calc(nums, cal);
        System.out.println(Arrays.toString(nums2));

         */
    }

    public static int[] calc(int[] nums, Calculator cal) {
        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums2[i] = cal.square(nums[i]); // 단일 기능
        }

        return nums2;
    }
}