package com.test.enum_;

/**
 * @author LiJing
 * @version 1.0
 * 使用 enum 实现枚举类
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WHAT);
    }
}

//1. 使用关键字enum 替代class
//   使用enum 关键字开发一个枚举类时，默认会继承Enum 类, 而且枚举类是一个final 类
//2. public static final Season SPRING = new Season("春天", "温暖");
//   简化成 SPRING("春天", "温暖") --- 常量名(实参列表)
//   这里必须知道，它调用的是哪个构造器.
//3. 当有多个枚举对象时，使用,间隔，最后有一个分号结尾
//4. 枚举对象必须放在枚举类的行首.
//5. 如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略
enum Season2 {
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"),
    WHAT;

    private String name;
    private String desc;

    private Season2() {
    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}