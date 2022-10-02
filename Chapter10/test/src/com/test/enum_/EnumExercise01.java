package com.test.enum_;

/**
 * @author LiJing
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy);//输出BOY //本质就是调用Gender的父类Enum的 toString()
        System.out.println(boy2 == boy);  //True
    }
}

enum Gender {
    BOY, GIRL;
}
