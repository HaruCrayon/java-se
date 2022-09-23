package com.test.extend_.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        C c = new C();//会输出什么？
    }
}

class A {//A类

    public A() {
        System.out.println("我是A类");
    }
}

class B extends A { //B类,继承A类
    public B() {
        System.out.println("我是B类的无参构造");
    }

    public B(String name) {
        //默认有 super()
        System.out.println(name + "我是B类的有参构造");
    }
}

class C extends B {   //C类，继承 B类
    public C() {
        this("hello");
        System.out.println("我是c类的无参构造");
    }

    public C(String name) {
        super("haha");
        System.out.println("我是c类的有参构造");
    }
}