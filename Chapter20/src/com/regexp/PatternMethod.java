package com.regexp;

import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * Pattern类的 matches方法, 用于整体匹配, 验证输入的字符串是否满足条件
 */
public class PatternMethod {
    public static void main(String[] args) {
        String content = "hello abc hello, smith";
//        String regStr = "hello";
        String regStr = "hello.*";

        boolean matches = Pattern.matches(regStr, content);
        System.out.println("整体匹配= " + matches);
    }
}
