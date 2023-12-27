package exam03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            boolean result = dis.readBoolean();
            int num = dis.readInt();
            String str = dis.readUTF();

            System.out.printf("result=%s, num=%d, str=%s%n", result, num, str);
            // 동일한 자료형을 사용하는 것이 권장된다.
            // 순서가 바뀌면 오류가 발생하기 때문이다.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
