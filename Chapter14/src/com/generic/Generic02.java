package com.generic;

import java.util.ArrayList;

/**
 * @author LiJing
 * @version 1.0
 */

/*
1.请编写程序，在ArrayList 中，添加3个Dog1对象
2.Dog1对象含有name 和 age, 并输出name 和 age (要求使用getXxx())
3.使用泛型来完成代码
 */

@SuppressWarnings({"all"})
public class Generic02 {
    public static void main(String[] args) {

        //1. ArrayList<Dog1> 表示存放到 ArrayList 集合中的元素是Dog1类型
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog1 类型而不是 Object
        //4. public class ArrayList<E> {} E称为泛型,那么 Dog1->E

        ArrayList<Dog1> arrayList = new ArrayList<Dog1>();
        arrayList.add(new Dog1("旺财", 10));
        arrayList.add(new Dog1("发财", 1));
        arrayList.add(new Dog1("小黄", 5));
        //假如程序员，不小心，添加了一只猫
//        arrayList.add(new Cat1("招财猫", 8));
        System.out.println("===使用泛型====");
        for (Dog1 Dog1 : arrayList) {
            System.out.println(Dog1.getName() + "-" + Dog1.getAge());
        }

    }
}

class Dog1 {
    private String name;
    private int age;

    public Dog1(String name, int age) {
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
}

class Cat1 { //Cat1类
    private String name;
    private int age;

    public Cat1(String name, int age) {
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
}
