package com.test;

/**
 * @author LiJing
 * @version 1.0
 */
public class Cat {
    private String name = "小花猫";
    public int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
//        System.out.println("hi " + name);
    }

    public void cry() {
        System.out.println(name + " 喵喵叫...");
    }
}
