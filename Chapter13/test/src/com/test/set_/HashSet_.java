package com.test.set_;

import java.util.HashSet;

/**
 * @author LiJing
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        //1. 在执行add方法后，会返回一个boolean值
        //2. 如果添加成功，返回 true, 否则返回false
        System.out.println(set.add("john"));//T
        System.out.println(set.add("lucy"));//T
        System.out.println(set.add("john"));//F
        System.out.println(set.add("jack"));//T
        System.out.println(set.add("Rose"));//T

        System.out.println("set=" + set);//4个

        //3. 可以通过 remove 指定删除哪个对象
        set.remove("john");
        System.out.println("set=" + set);//3个

        set = new HashSet();
        System.out.println("set=" + set);//0

        //4. Hashset 不能添加相同的元素/数据?
        set.add("lucy");//添加成功
        set.add("lucy");//加入不了
        set.add(new Dog("tom"));//OK
        set.add(new Dog("tom"));//Ok
        System.out.println("set=" + set);

        //再加深一下. 非常经典的面试题.
        //看源码，即 add 到底发生了什么?=> 底层机制.
        set.add(new String("smith"));//ok
        set.add(new String("smith"));//加入不了.
        System.out.println("set=" + set);

    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
