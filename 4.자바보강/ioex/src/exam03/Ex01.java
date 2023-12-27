package exam03;

import java.io.FileWriter;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("test4.txt")) {
            // 한글 깨짐 방지를 위해 문자 스트림은 FileWriter를 사용한다.
            fw.write("안녕하세요.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
