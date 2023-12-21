package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public void setYear(int _year) { // setter
        year = _year;
    }

    public int getYear() { // getter
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int _day) {
        if(_day > 28) _day = 28;

        day = _day;
    }

    public int getDay(int day) {
        return day;
    }

    void showDate() {
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
