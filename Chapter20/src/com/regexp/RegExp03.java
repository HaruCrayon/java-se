package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * 选择匹配符
 */
public class RegExp03 {
    public static void main(String[] args) {

        String content = "shang 上下左右 尚";
        String regStr = "shang|上|尚";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
