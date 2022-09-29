package com.test.static_;

public class StaticVariable {
    public static void main(String[] args) {
        Child child1 = new Child("jack");
        child1.join();
        child1.count++;//对象名.类变量名

        Child child2 = new Child("harry");
        child2.join();
        Child.count++;//类名.类变量名

        Child child3 = new Child("smith");
        child3.join();
        child3.count++;

        System.out.println("共有" + Child.count + "个小孩加入了游戏");
        System.out.println("child1.count=" + child1.count);
        System.out.println("child2.count=" + child2.count);
        System.out.println("child3.count=" + child3.count);
    }
}

class Child {
    private String name;
    //静态变量count是 Child类的所有对象共享的
    public static int count;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + "加入了游戏");
    }
}