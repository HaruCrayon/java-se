package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/*
编写应用程序，接收命令行的两个参数(整数)，计算两数相除。
计算两个数相除，要求使用方法 cal(int n1, int n2)
对数据格式不正确(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)、
除0 进行异常处理(ArithmeticException)。
 */
public class Homework01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            double res = cal(num1, num2);
            System.out.println("结果=" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确，需要输入整数");
        } catch (ArithmeticException e) {
            System.out.println("出现了除0的异常");
        }
    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
