package exam02;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex01 {
    public static void main(String[] args) {
        //Set<String> names = new HashSet<>();
        Set<String> names = new TreeSet<>();

        names.add("이름5");
        names.add("이름1");
        names.add("이름2");
        names.add(new String("이름2"));
        names.add("이름3");
        names.add("이름4");


        System.out.println(names);
    }
}