package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/**
 * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 * 思路分析
 * (1) 遍历字符串，如果 char 在 '0'~'9' 就是一个数字
 * (2) 如果 char 在 'a'~'z' 就是一个小写字母
 * (3) 如果 char 在 'A'~'Z' 就是一个大写字母
 * (4) 使用三个变量来记录 统计结果
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "Ajhh90 H Yell* 7";
        countStr(str);

    }

    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入的字符串不能为null");
            return;
        }

        int digitNum = 0;
        int lowerNum = 0;
        int upperNum = 0;
        int otherNum = 0;
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digitNum++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerNum++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                upperNum++;
            } else {
                otherNum++;
            }
        }

        System.out.println("数字个数=" + digitNum);
        System.out.println("小写字母个数=" + lowerNum);
        System.out.println("大写字母个数=" + upperNum);
        System.out.println("其他字符个数=" + otherNum);

    }
}
