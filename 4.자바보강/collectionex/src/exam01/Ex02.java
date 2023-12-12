package exam01;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        // System.out.println(names);

        // for (int i = 0; i < names.size(); i++) {
        //    names.remove(i);
        // }

        for(int i = names.size() -1; i >= 0; i--) {
            String name = names.remove(i);
            System.out.println(name);
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }

    }
}

/* 결과값으로 이름2 그리고 이름4가 나오는 이유
   이름1, 이름2, 이름3, 이름4, 이름5에서 이름1이 사라지고 순서가 당겨져서 새로 만들어지기 때문
   뒤에서부터 삭제한다면 순서에 영향을 주지 않으므로 온전히 삭제할 수 있다.
 */