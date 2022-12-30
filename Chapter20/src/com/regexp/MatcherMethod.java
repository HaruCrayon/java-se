package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * Matcher类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello jack harrytom hello smith hello harry harry";
        String regStr = "hello";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("=================");
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println("找到: " + content.substring(matcher.start(), matcher.end()));
        }

        //整体匹配方法，常用于，校验某个字符串是否满足某个规则
        System.out.println("整体匹配=" + matcher.matches());

        //完成：如果content 有 harry 替换成 哈利
        regStr = "harry";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //注意：返回的字符串才是替换后的字符串 原来的 content 不变化
        String newContent = matcher.replaceAll("哈利");
        System.out.println("newContent=" + newContent);
        System.out.println("content=" + content);
    }
}
