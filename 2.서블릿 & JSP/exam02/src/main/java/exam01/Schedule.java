package exam01;

public class Schedule {
    private int year; // 년 설정

    private int month; // 월 설정

    private int day; // 일 설정

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
    // 만약 day 값이 28 이상 이면 28로 지정
        if(day > 28) day = 28;

        this.day = day;
    }

    // 년, 월, 일을 한번에 보여 주는 메소드 생성
    void showDate() {
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
