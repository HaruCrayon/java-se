package com.homework;

import java.util.TreeSet;

/**
 * @author LiJing
 * @version 1.0
 */

//下面代码运行会不会抛出异常，并从源码层面说明原因
//    考察【读源码+接口编程+动态绑定】
//    TreeSet 是如何实现去重的
@SuppressWarnings({"all"})
public class Homework04 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //分析源码
        //因为 TreeSet() 构造器没有传入Comparator接口的匿名内部类
        //所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //即 把 Person1转成 Comparable类型

        treeSet.add(new Person1());//ClassCastException.
//        treeSet.add(new Person1());
//        treeSet.add(new Person1());

        System.out.println(treeSet);

    }
}

class Person1 {}

//class Person1 implements Comparable{
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
