package exam01;

import java.util.Calendar;

public class Ex02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.roll(Calendar.DAY_OF_MONTH, 100);
        showDate(cal);
    }
    private static void showDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH); // 0 ~ 11
        int date = cal.get(Calendar.DAY_OF_MONTH);

        System.out.printf("year=%d, month=%d, date=%d%n", year, month + 1 , date);
    }

}
