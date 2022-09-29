package com.test.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu jack = new Stu("jack");
        jack.payFee(100);
        Stu.payFee(200);

        Stu tom = new Stu("tom");
        tom.payFee(300);

        Stu.showFee();//类名.方法名
        jack.showFee();//对象名.方法名
    }
}

class Stu {
    private String name;
    private static double fee;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("当前共收学费:" + fee);
    }
}
