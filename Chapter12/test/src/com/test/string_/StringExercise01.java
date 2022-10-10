package com.test.string_;

/**
 * @author LiJing
 * @version 1.0
 */
public class StringExercise01 {
    public static void main(String[] args) {
        String a = "jack"; //a 指向 常量池的 “jack”
        String b = new String("jack");//b 指向堆中对象
        System.out.println(a.equals(b)); //T
        System.out.println(a == b); //F
        //b.intern() 方法返回常量池地址
        System.out.println(a == b.intern()); //T
        System.out.println(b == b.intern()); //F

    }
}
