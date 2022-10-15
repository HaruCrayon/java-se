package com.test.set_;

/**
 * @author LiJing
 * @version 1.0
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * 定义一个Employee类，该类包含：private成员属性name,sal,birthday(MyDate类型，
 * 属性包括 year,month,day)
 * 要求:
 * 创建3个Employee 对象放入 HashSet中
 * 当 name和 birthday的值相同时，认为是相同员工, 不能添加到HashSet集合中
 */

@SuppressWarnings({"all"})
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee01("jack", 2000, new MyDate("2010", "08", "11")));
        hashSet.add(new Employee01("harry", 4000, new MyDate("2019", "09", "23")));
        hashSet.add(new Employee01("jack", 6000, new MyDate("2010", "08", "11")));

        System.out.println("hashSet=" + hashSet);
    }
}

class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) && Objects.equals(month, myDate.month)
                && Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

class Employee01 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee01(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee01{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}