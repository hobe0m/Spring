package exam03;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        System.out.print("아무거나 입력 : ");
        // char ch = (char)System.in.read();
        // blocking(블로킹) 상태 : 입력받을 때까지 하단 코드(다음 로직)가 실행되지 않는다.
        // 한글도 문자지만, 한글은 깨진다(문자표가 아스키 코드이기 때문에, 한글은 유니코드)

        InputStreamReader isr = new InputStreamReader(System.in); // 변환 메소드
        BufferedReader br = new BufferedReader(isr); // 버퍼까지 쓰는 게 일반적이다.
        char ch = (char)br.read();

        // char ch = (char)System.in.read(); (X)
        // char ch = (char)isr.read();

        System.out.println(ch);
    }
}
