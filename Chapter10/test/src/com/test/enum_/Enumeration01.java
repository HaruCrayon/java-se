package com.test.enum_;

/**
 * @author LiJing
 * @version 1.0
 * 自定义类实现枚举
 */
public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
    }
}

//1. 将构造器私有化, 防止直接new
//2. 去掉setXxx 方法, 防止属性被修改
//3. 在Season类内部，直接创建一组固定的对象
//4. 对外暴露对象。对枚举对象/属性使用 public final static 共同修饰，实现底层优化。
class Season{
    private String name;
    private String desc;

    //在本类内部创建一组对象
    public final static Season SPRING = new Season("春天","温暖");
    public final static Season SUMMER = new Season("夏天","炎热");
    public final static Season AUTUMN = new Season("秋天","凉爽");
    public final static Season WINTER = new Season("冬天","寒冷");

    private Season(String name, String desc) {
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