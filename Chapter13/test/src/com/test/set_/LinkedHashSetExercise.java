package com.test.set_;

/**
 * @author LiJing
 * @version 1.0
 */

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * Car 类(属性:name,price)，  如果 name 和 price 一样，
 * 则认为是相同元素，就不能添加。
 */

@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 1000));
        linkedHashSet.add(new Car("奥迪", 300000));
        linkedHashSet.add(new Car("法拉利", 10000000));
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了
        linkedHashSet.add(new Car("保时捷", 70000000));
        linkedHashSet.add(new Car("奥迪", 300000));//加入不了

        System.out.println("linkedHashSet=" + linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //重写 equals()方法 和 hashCode()方法
    //当 name 和 price 相同时，就返回相同的hashCode值，equals返回t
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}