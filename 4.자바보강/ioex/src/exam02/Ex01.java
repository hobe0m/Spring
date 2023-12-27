package exam02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {

        long stime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("specs.zip");
             FileOutputStream fos = new FileOutputStream("specs_copied.zip")) {

            while(fis.available() > 0) {
                fos.write(fis.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long etime = System.currentTimeMillis();
        System.out.printf("걸린 시간 : %d%n", etime - stime);
    }
}