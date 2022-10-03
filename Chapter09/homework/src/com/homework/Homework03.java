package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/*
考察对匿名内部类的使用
1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone，
   定义方法testWork测试计算功能，调用计算器接口的work方法，
2.要求调用CellPhone对象 的testWork方法，使用上 匿名内部类
 */
public class Homework03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return (n1 + n2);
            }
        }, 10, 5);
    }
}

interface Calculator {
    double work(double n1, double n2);
}

class Cellphone {
    public void testWork(Calculator cal, double n1, double n2) {
        double result = cal.work(n1, n2);
        System.out.println("计算结果=" + result);
    }
}
