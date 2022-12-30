package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiJing
 * @version 1.0
 * 非捕获分组
 */
public class RegExp07 {
    public static void main(String[] args) {
        String content = "hello小王教育 jack小王老师 小王同学hello小王学生";

//        找到 小王教育 、小王老师、小王同学 子字符串
        //String regStr = "小王教育|小王老师|小王同学";
        //上面的写法可以等价非捕获分组, 注意：不能 matcher.group(1)
        //String regStr = "小王(?:教育|老师|同学)";

        //找到 小王 这个关键字,但是要求只是查找小王教育和 小王老师 中包含有的小王
        //下面也是非捕获分组，不能使用 matcher.group(1)
        //String regStr = "小王(?=教育|老师)";

        //找到 小王 这个关键字,但是要求只是查找 不是 (小王教育 和 小王老师) 中包含有的小王
        //下面也是非捕获分组，不能使用 matcher.group(1)
        String regStr = "小王(?!教育|老师)";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}
