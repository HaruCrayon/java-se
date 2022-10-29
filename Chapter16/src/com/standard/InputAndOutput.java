package com.standard;

import java.util.Scanner;

/**
 * @author LiJing
 * @version 1.0
 */
public class InputAndOutput {
    public static void main(String[] args) {
        //System.in
        //1. System类的属性 public final static InputStream in = null;
        //2. System.in 编译类型   InputStream
        //   System.in 运行类型   BufferedInputStream
        //3. 表示 标准输入 键盘
        System.out.println(System.in.getClass());

        //System.out
        //1. public final static PrintStream out = null;
        //2. 编译类型 PrintStream
        //   运行类型 PrintStream
        //3. 表示 标准输出 显示器
        System.out.println(System.out.getClass());

        System.out.println("hello,java");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);
    }
}
