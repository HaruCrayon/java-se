package com.test.string_;

/**
 * @author LiJing
 * @version 1.0
 */
public class StringExercise05 {
    public static void main(String[] args) {
        //以下语句创建了几个对象？//一共创建了3个String对象
        //关键就是要分析 String c = a + b; 到底是如何执行的【看源码】

        String a = "hello"; //创建 a对象
        String b = "abc";//创建 b对象

        //1. 在堆中，先创建一个 StringBuilder sb = new StringBuilder()
        //2. 执行 sb.append("hello");
        //3. sb.append("abc");
        //4. String c = sb.toString()//这里返回一个String对象  return new String(value, 0, count);
        //   最后 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
        String c = a + b;//debug 查看源码
        String d = "helloabc";
        System.out.println(c == d);//False
        String e = "hello" + "abc";//直接看池, e指向常量池
        System.out.println(d == e);//True

        /*
        重要规则：
        String s1 = "ab" + "cd";//常量相加，看的是池
        String s2 = a + b;//变量相加，是在堆中
         */
    }
}
