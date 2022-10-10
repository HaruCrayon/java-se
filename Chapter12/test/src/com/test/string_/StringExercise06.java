package com.test.string_;

/**
 * @author LiJing
 * @version 1.0
 */
public class StringExercise06 {
    public static void main(String[] args) {
        String s1 = "hello";  //s1 指向池中的 “hello”
        String s2 = "java"; // s2 指向池中的 “java”
        String s5 = "hellojava"; //s5 指向池中的 “hellojava”
        String s6 = (s1 + s2).intern();//s6 指向池中的 “hellojava”
        System.out.println(s5 == s6); //T
        System.out.println(s5.equals(s6));//T

    }
}
