package exam03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("아무거나 입력 : ");
        String str = sc.nextLine();
        System.out.println(str);

        // BufferedReader나 InputStreamReader를 사용하지 않아도 동일한 결과 출력
    }
}
