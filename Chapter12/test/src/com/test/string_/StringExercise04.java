package com.test.string_;

/**
 * @author LiJing
 * @version 1.0
 */

public class StringExercise04 {
    public static void main(String[] args) {
        //1.String 是一个 final 类，代表不可变的字符序列
        //2.字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的
        //以下语句创建了几个对象？

        //题目1
        String s1 = "hello";
        s1 = "haha";
        //在常量池, 创建了2个字符串常量对象

        //题目2
        String s2 = "hello" + "abc";//创建了1个对象
        //编译器会做一个优化，判断创建的常量池对象，是否有引用指向
        //String s2 = "hello" + "abc"; ==> String s2 = "helloabc";

    }

}
