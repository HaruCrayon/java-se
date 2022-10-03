package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

/*
有一个Car类，有属性temperature（温度），车内有Air（空调）类，有吹风的功能flow，
Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，
如果在这之间则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，
测试空调吹的风是否正确 .
//体现 类与类的包含关系的案例 类(内部类【成员内部类】)
 */
public class Homework06 {
    public static void main(String[] args) {
        Car car1 = new Car(39.8);
        car1.getAir().flow();
        Car car2 = new Car(42);
        car2.getAir().flow();
        Car car3 = new Car(-2.5);
        car3.getAir().flow();
    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("温度超过40度, 吹冷气");
            } else if (temperature < 0) {
                System.out.println("温度低于0度, 吹暖气");
            } else {
                System.out.println("温度正常, 关掉空调");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}
