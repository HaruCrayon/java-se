package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * 非贪婪匹配 其他限定符后跟 ?
 */
public class RegExp08 {
    public static void main(String[] args) {
        String content = "hello111111 ok";
//        String regStr = "\\d+"; //默认是贪婪匹配
        String regStr = "\\d+?"; //非贪婪匹配

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
