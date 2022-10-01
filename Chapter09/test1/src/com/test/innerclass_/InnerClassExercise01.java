package com.test.innerclass_;

/*
 匿名内部类的最佳实践
 */
public class InnerClassExercise01 {
    public static void main(String[] args) {
        //当做实参直接传递，简洁高效
        f1(new IB() {
            @Override
            public void show() {
                System.out.println("这是一幅画...");
            }
        });

    }

    public static void f1(IB ib) {
        ib.show();
    }
}

interface IB {
    void show();
}