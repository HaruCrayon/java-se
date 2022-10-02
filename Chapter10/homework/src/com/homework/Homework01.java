package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/*
    题目：
    创建一个Color枚举类
    1.有 RED,BLUE,BLACK,YELLOW,GREEN这个五个枚举值/对象；
    2.Color有三个属性redValue，greenValue，blueValue，
    3.创建构造方法，参数包括这三个属性，
    4.每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
    red：255,0,0  blue:0,0,255  black:0,0,0  yellow:255,255,0  green:0,255,0
    5.定义接口，里面有方法show，要求Color实现该接口
    6.show方法中显示三属性的值
    7. 将枚举对象在switch语句中匹配使用
 */
public class Homework01 {
    public static void main(String[] args) {
        Color color = Color.GREEN;
        color.show();

        switch (color) {
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            default:
                System.out.println("没有匹配到颜色");
        }
    }
}

interface IF {
    void show();
}

enum Color implements IF {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为:" + redValue + "," + greenValue + "," + blueValue);
    }
}

