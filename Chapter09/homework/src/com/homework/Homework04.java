package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/*
编一个类A，在类中定义局部内部类B，B中有一个私有final常量name，有一个方法show()打印常量name。进行测试
进阶：A中也定义一个私有的变量name，在show方法中打印测试
 */
public class Homework04 {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
    }
}

class A {
    private String NAME = "jack";

    public void m1() {
        class B {
            private final String NAME = "harry";

            public void show() {
                System.out.println("常量name=" + NAME + "\t外部类A的name=" + A.this.NAME);
            }
        }

        B b = new B();
        b.show();
    }
}
