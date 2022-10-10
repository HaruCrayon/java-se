package com.test.wrapper;

/**
 * @author LiJing
 * @version 1.0
 * 包装类型和 String类型的相互转换
 */

public class IntegerToString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;//自动装箱
        //方式1
        String str1 = i + "";
        //方式2
        String str2 = i.toString();
        //方式3
        String str3 = String.valueOf(i);

        //String -> 包装类(Integer)
        String str4 = "12345";
        //方式1
        Integer i2 = Integer.parseInt(str4);//返回值是int类型, 使用到自动装箱
        //方式2
        Integer i3 = new Integer(str4);//构造器

        System.out.println("ok~");

    }
}