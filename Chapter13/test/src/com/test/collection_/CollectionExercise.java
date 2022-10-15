package com.test.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */

/**
 * 创建  3个 Dog {name, age}  对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强for循环两种方式来遍历
 * 重写Dog 的toString方法， 输出name和age
 */
public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小黄", 9));
        list.add(new Dog("大白", 3));
        list.add(new Dog("jack", 1));
//        System.out.println(list);

        System.out.println("===iterator迭代器遍历集合元素");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }

        System.out.println("===增强for循环 遍历");
        for (Object obj : list) {
            System.out.println("obj=" + obj);
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}