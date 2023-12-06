package exam01;

import static exam01.Transportation.*;

public class Ex01 {
    public static void main(String[] args) {
        Transportation bus = Transportation.BUS;
        System.out.println(bus == Transportation.BUS);
        System.out.printf("ordinal() : %d, name() : %s%n", bus.ordinal(), bus.name());

        Transportation subway = Transportation.SUBWAY;
        System.out.println(subway == Transportation.SUBWAY);

        Transportation taxi = Transportation.TAXI;
        System.out.println(taxi == Transportation.TAXI);
    }
}
