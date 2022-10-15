package com.test.set_;

/**
 * @author LiJing
 * @version 1.0
 */

import java.util.HashSet;
import java.util.Objects;

/**
 * 定义一个Employee类，该类包含：private成员属性name,age 要求:
 * 创建3个Employee 对象放入 HashSet中
 * 当 name和age的值相同时，认为是相同员工, 不能添加到HashSet集合中
 */

@SuppressWarnings({"all"})
public class HashSetExercise01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("jack", 10));
        hashSet.add(new Employee("smith", 20));
        hashSet.add(new Employee("jack", 10));//加入不了
        hashSet.add(new Employee("harry", 20));

        System.out.println("hashSet=" + hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //如果name 和age 值相同，则返回相同的hash 值
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}