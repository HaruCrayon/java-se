package com.homework;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author LiJing
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {

        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        Car car3 = new Car("奥迪", 3800000);
        Car car4 = new Car("比亚迪", 200000);
//         使用ArrayList 完成对 对象 Car {name, price} 的各种操作
        ArrayList arrayList = new ArrayList();
//         1.add:添加单个元素
        arrayList.add(car1);
        arrayList.add(car2);
        System.out.println("arrayList=" + arrayList);
//         2.remove:删除指定元素
        arrayList.remove(car1);
        System.out.println("arrayList=" + arrayList);
//         3.contains:查找元素是否存在
        System.out.println(arrayList.contains(car1));
//         4.size:获取元素个数
        System.out.println(arrayList.size());
//         5.isEmpty:判断是否为空
        System.out.println(arrayList.isEmpty());

//         6.clear:清空
//        arrayList.clear();
//        System.out.println("arrayList=" + arrayList);

//         7.addAll:添加多个元素
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(car3);
        arrayList1.add(car4);
        arrayList.addAll(arrayList1);
        System.out.println("arrayList=" + arrayList);

//         8.containsAll:查找多个元素是否都存在
        System.out.println(arrayList.containsAll(arrayList1));

//         9.removeAll：删除多个元素
//        arrayList.removeAll(arrayList1);
//        System.out.println("arrayList=" + arrayList);

//         10.使用增强for和 迭代器来遍历所有的car , 需要重写 Car 的toString方法
        System.out.println("=== 增强for 遍历 ===");
        for (Object o : arrayList) {
            System.out.println(o);
        }

        System.out.println("=== 迭代器 遍历 ===");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}