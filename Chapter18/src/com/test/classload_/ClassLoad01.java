package com.test.classload_;

/**
 * @author LiJing
 * @version 1.0
 * 类加载-连接阶段-准备
 */
public class ClassLoad01 {
    public static void main(String[] args) {

    }
}

class A {
    //属性-成员变量-字段
    //类加载的连接阶段-准备 属性是如何处理
    //1. n1 是实例属性, 不是静态变量(类变量), 因此在准备阶段, 不会分配内存
    //2. n2 是静态变量, 分配内存 n2 是默认初始化0, 而不是20
    //3. n3 是static final 是常量, 它和静态变量不一样, 因为一旦赋值就不变 n3 = 30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}