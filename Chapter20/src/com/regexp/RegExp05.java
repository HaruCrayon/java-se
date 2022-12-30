package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 */
public class RegExp05 {
    public static void main(String[] args) {

        String content = "hanabcd xzhan nnhan";
        //String content = "123-abc";
        //以至少1个数字开头，后接任意个小写字母的字符串
        //String regStr = "^[0-9]+[a-z]*";
        //以至少1个数字开头, 必须以至少一个小写字母结束
        //String regStr = "^[0-9]+\\-[a-z]+$";

        //表示匹配边界的han [这里的边界是指：被匹配的字符串最后, 也可以是子串间有空格]
        String regStr = "han\\b";

        //和\\b的含义刚刚相反
//        String regStr = "han\\B";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
