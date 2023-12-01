package exam03;

public class C extends B {
    int numC = 30;

    public C() { // 기본 생성자가 없으면 객체 생성 불가
        super(); // super : 부모 클래스의 기본 생성자 추가, 따라서 B()가 생성된다.
        System.out.println("C 생성자!");

    // C() - super() : B() - super() : A()의 구조이며, 순서대로 호출된다.
    /* [    C객체 : int numC = 30;
            {   B객체 :int numB = 20;
                (   C객체 : int numC = 10;
                )
            }
        }
        이러한 구조로 이루어져 있다.
        따라서 int C = int num C, int num B, int num A
              int B = int num B, int num A,
              int A = int num A
        
        이것이 가능한 이유는 super가 있기 때문, 하위 객체가 상위 객체 사용 가능
        super 하위 클래스가 상위 클래스의 자원 사용 가능
     */

    }


}
