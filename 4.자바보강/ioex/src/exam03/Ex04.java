package exam03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.dat"); // 기반 스트림
             DataOutputStream dos = new DataOutputStream(fos)) { // 보조 스트림

            dos.writeBoolean(true);
            dos.writeInt(100);
            dos.writeUTF("안녕하세요");
            // 동일한 자료형을 사용하는 것이 권장된다.
            // 순서가 바뀌면 오류가 발생하기 때문이다.


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
