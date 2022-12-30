package com.regexp.test;

/**
 * @author LiJing
 * @version 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        //规定电子邮件规则为
        //只能有一个@
        //@前面是用户名,可以是a-z A-Z 0-9 _-字符
        //@后面是域名,并且域名只能是英文字母， 比如 sohu.com 或者 tsinghua.org.cn
        //        写出对应的正则表达式, 验证输入的字符串是否为满足规则

        String content = "hsp@tsinghua.org.cn";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        if (content.matches(regStr)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }

        //1. String 的 matches 是整体匹配
        //2. 这个matches 底层
        /*
         * String类 的 matches
         *  public boolean matches(String regex) {
         *         return Pattern.matches(regex, this);
         *     }
         *
         *  Pattern类
         *  public static boolean matches(String regex, CharSequence input) {
         *         Pattern p = Pattern.compile(regex);
         *         Matcher m = p.matcher(input);
         *         return m.matches();
         *     }
         *
         *  Mather类 match
         *  Attempts to match the entire region against the pattern
         *  public boolean matches() {
         *         return match(from, ENDANCHOR);
         *     }
         */

    }
}
