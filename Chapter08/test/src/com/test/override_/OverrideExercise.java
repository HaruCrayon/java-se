package com.test.override_;

public class OverrideExercise {
    public static void main(String[] args) {
        Person harry = new Person("harry", 20);
        System.out.println(harry.getInfo());

        Student jack = new Student("jack", 18, "151234", 89);
        System.out.println(jack.getInfo());
    }

}
