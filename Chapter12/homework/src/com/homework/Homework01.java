package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/**
 * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
 * (2) 编写方法 public static String reverse(String  str, int start , int end) 搞定
 * 思路分析
 * (1) 确定方法定义
 * (2) 把 String 转成 char[] ，因为char[] 的元素是可以交换的
 * (3) 画出分析示意图
 * (4) 代码实现
 */
public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);

        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);

    }

    public static String reverse(String str, int start, int end) {

        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);

    }
}

