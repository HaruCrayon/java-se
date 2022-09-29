package com.test.main_;

/*
1. 在 main()方法中，可以直接调用 main()方法所在类的静态成员。
2. 但是，不能直接访问该类中的非静态成员。
   必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员。
 */
public class Main02 {
    //静态变量
    private static String name = "lee";
    //非静态变量
    private int n1 = 20;
    //静态方法
    private static void hi() {
        System.out.println("Main02 hi()方法");
    }
    //非静态方法
    private void say() {
        System.out.println("Main02 say()方法");
    }

    public static void main(String[] args) {
        System.out.println("name=" + name);
        //System.out.println("n1="+n1);//×
        hi();
        //say();//×

        Main02 m = new Main02();
        System.out.println("n1=" + m.n1);
        m.say();

    }
}
