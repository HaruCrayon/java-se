package com.test.string_;

/**
 * @author LiJing
 * @version 1.0
 */
public class StringExercise03 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "harry";
        Person p2 = new Person();
        p2.name = "harry";

        System.out.println(p1.name.equals(p2.name));//比较内容: True
        System.out.println(p1.name == p2.name);  //T
        System.out.println(p1.name == "harry");   //T

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2); //False

    }
}

class Person {
    public String name;
}