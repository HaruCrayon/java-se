package com.test.exception_;

/**
 * @author LiJing
 * @version 1.0
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "jack";
        //将String 转成 int
        int num = Integer.parseInt(name);//抛出NumberFormatException
        System.out.println(num);
    }
}
