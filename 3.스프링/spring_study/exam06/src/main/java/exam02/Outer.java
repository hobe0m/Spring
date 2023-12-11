package exam02;

public class Outer {

    Calculator method(int num3) {
        return new Calculator() { // 익명 내부 클래스 형태
            // Calculator cal는 스택(Stack)에 생성
            // new Calculator()는 힙(Hip)에 생성

            public int add(int num1, int num2) {
                // num3 = 40;
                return num1 + num2 + num3;
            }
        };
    }


    /*
    void method() {
        // 여기(메소드 내부)에 정의된 클래스가 지역 내부 클래스
        class Inner {
            void innerMethod() {
                System.out.println("지역 내부 클래스!");
                // 지역 내, 특수한 환경 내에서만 사용
            }
        }

        Inner in = new Inner(); // 객체 생성
        in.innerMethod(); // 메소드 사용
    }
     */
}
