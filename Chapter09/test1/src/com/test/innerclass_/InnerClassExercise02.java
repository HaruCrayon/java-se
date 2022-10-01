package com.test.innerclass_;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        //1. 传递的是实现了Bell接口的匿名内部类InnerClassExercise02$1
        //2. 重写了ring
//        Bell bell = new Bell() {
//            @Override
//            public void ring() {
//                System.out.println("起床了...");
//            }
//        };
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("起床了...");
            }
        });

        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("上课了...");
            }
        });

    }
}

interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        System.out.println(bell.getClass());
        bell.ring();//动态绑定机制
    }
}