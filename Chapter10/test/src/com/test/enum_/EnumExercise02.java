package com.test.enum_;

/**
 * @author LiJing
 * @version 1.0
 */

/*
    声明Week 枚举类，其中包含星期一至星期日的定义；
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    使用values 返回所有的枚举数组, 并遍历, 输出
*/
public class EnumExercise02 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        System.out.println("===所有星期的信息如下===");
        for(Week week: weeks){
            System.out.println(week);
        }
    }
}

enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private String name;

    private Week(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}