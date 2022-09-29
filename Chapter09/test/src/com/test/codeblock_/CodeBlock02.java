package com.test.codeblock_;

public class CodeBlock02 {
    public static void main(String[] args) {
        new C02();
    }
}

class C02 {
    private int n1 = 100;
    private static  int n2 = 200;

    private void m1() {

    }
    private static void m2() {

    }

    static {
        //静态代码块，只能调用静态成员
        //System.out.println(n1);//×
        System.out.println(n2);
        //m1();//×
        m2();
    }
    {
        //普通代码块，可以调用任意成员
        System.out.println(n1);
        System.out.println(n2);
        m1();
        m2();
    }
}
