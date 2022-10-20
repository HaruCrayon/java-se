package com.junit_;

import org.junit.jupiter.api.Test;

/**
 * @author LiJing
 * @version 1.0
 * JUnit 单元测试类的使用
 */
public class JUnit_ {
    public static void main(String[] args) {
        //传统测试方式
        //new JUnit_().m1();
        //new JUnit_().m2();

    }


    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
