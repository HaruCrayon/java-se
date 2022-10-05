package com.test.exception_;

/**
 * @author LiJing
 * @version 1.0
 */
public class ArithmeticException_ {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
//        double res = num1/num2;
        try {
            double res = num1 / num2;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("发生异常的原因:" + e.getMessage());//输出异常信息
        }

        System.out.println("程序继续运行...");
    }
}
