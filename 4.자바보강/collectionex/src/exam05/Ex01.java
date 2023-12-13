package exam05;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름3");
        // names.add("이름4");
        System.out.println(names);

        int[] nums = new int[10];
        Arrays.fill(nums, 1);
        System.out.println(nums); // 값이 아닌 주소만 출력된다.
        System.out.println(Arrays.toString(nums));
    }
}
