package com.company.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("Results of ex1_1:");
        ex1_1();
        System.out.println("It should be: \ntrue\nfalse");

        System.out.println("Results of ex1_2:");
        ex1_2();
        System.out.println("It should be: \n[Bob, Bobby, Bobbick]");

        System.out.println("Results of ex1_3:");
        ex1_3();
        System.out.println("It should be: \n Bob");

    }

    //Implement method isNotEqualTo returning if names aren't equal
    public static void ex1_1() {
        String name1 = "Bob";
        String name2 = "Bobby";
        System.out.println(isNotEqualTo(name1, name2));
        System.out.println(isNotEqualTo(name1, "Bob"));
    }

    public static boolean isNotEqualTo(String first, String second) {
        return !Objects.equals(first,second);   // vsegda proveriaet chtob ne null
//        !first.equals(second);//todo ex1_1
    }

    //Implement method toList taking multiple names and returning List of these names
    public static void ex1_2() {
        String name1 = "Bob";
        String name2 = "Bobby";
        String name3 = "Bobbick";
        System.out.println(toList(name1, name2, name3));
    }

    public static List<String> toList(String... names) {
List<String> list = new ArrayList<>();
      return List.of(names); //todo
    }

    //Implement method getFirst returning first element of list
    //You should firstly properly implement method from ex1_2
    public static void ex1_3() {
        String name1 = "Bob";
        String name2 = "Bobby";
        String name3 = "Bobbick";
        System.out.println(getFirst(toList(name1, name2, name3)));
    }

    private static String getFirst(List<String> names) {
        return names.stream().findFirst().orElseThrow();
//                names.get(0);

    }

}
