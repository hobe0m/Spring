package exam02;

import java.time.LocalDate;

public class Ex01 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 12, 29);
        System.out.println(date1);

        LocalDate date2 = LocalDate.now();
        System.out.println(date2);
    }
}
