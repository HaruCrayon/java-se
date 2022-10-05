package com.test.trycatch_;

import java.util.Scanner;

/**
 * @author LiJing
 * @version 1.0
 */

public class TryCatchExercise03 {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        int num = 0;
        while (true) {
            System.out.print("请输入一个整数:");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);//这里可能抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println("你输入的值是:" + num);
    }
}
