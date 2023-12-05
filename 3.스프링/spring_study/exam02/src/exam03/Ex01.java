package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Animal human = new Human();
        human.move();

        Animal dog = new Dog();
        dog.move();

        Animal bird = new Bird();
        bird.move();

        // 같은 자료형이 아니기 때문에, 배열에 담지 못한다.
    }
}
