package exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("book.obj");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Map<String, Object> data = (Map<String, Object>) ois.readObject();

            String str = (String)data.get("str");
            Book b1 = (Book)data.get("book1");
            /*
            Book b1 = (Book)ois.readObject();
            System.out.println(b1);

            Book b2 = (Book)ois.readObject();
            System.out.println(b2);

            String str = (String)ois.readObject();
            System.out.println(str);
            */
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
