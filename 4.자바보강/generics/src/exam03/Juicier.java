package exam03;

import exam02.Fruit;

public class Juicier {

    public static void make(FruitBox<? super Apple> fruitBox) { // Apple, Fruit, Object
        System.out.println(fruitBox.getItems());
    }

    public  static <T extends Fruit> void make2(FruitBox<T>  fruitBox) {
        System.out.println(fruitBox.getItems());
    }
}



    /*
    public static void make(FruitBox<?> appleBox) {

    }
    */

    // 오류가 발생하는 이유는 매개 변수가 같기 때문이다.
    // 컴파일 시 <>가 제거되기 때문에 메소드 중복 정의가 된다.

    /*
    public static void make(FruitBox<Pear> pearBox) {

    }
    */
