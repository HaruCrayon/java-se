package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * 转义符 \\
 */
public class RegExp01 {
    public static void main(String[] args) {
        //需要用到转义符号的字符有：. * + ( ) $ / \ ? [ ] ^ { }
        String content = "a-bc$(a.bc(123( )";
        //匹配( => \\(
        //匹配. => \\.
//        String regStr = "\\.";
        String regStr = "\\(";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
