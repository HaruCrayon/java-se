package com.test.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口多态传递
        //如果 B接口 继承了 A接口，而Person类实现了 B接口
        //那么，实际上就相当于Person类也实现了 A接口.
        B b = new Person();
        A a = new Person();

    }
}

interface A {
    void say();
}

interface B extends A {
}

class Person implements B {

    @Override
    public void say() {

    }
}