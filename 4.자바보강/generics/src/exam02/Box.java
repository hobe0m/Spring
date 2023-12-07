package exam02;

public class Box<T extends Fruit> {
    private T item;

    // 처음부터 공간이 있어야 하고, 얼만큼 필요한지 모르기 때문에 static 사용불가
    //private  static T item2;
    // 메모리에 할당하기 위해 공간이 얼만큼 필요한지 확실히 알지 못해서 배열 사용 불가
    // private T[] item3 = new T[];

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
    
    public void printItem() {
        // T -> Object, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        // T -> Fruit, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        item.print();
    }
}
