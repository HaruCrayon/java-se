package com.test.extend_;

public class TestExtends {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name="jack";
        pupil.age=9;
        pupil.setScore(78.8);
        pupil.testing();
        pupil.showInfo();
        System.out.println("================");

        Graduate graduate = new Graduate();
        graduate.name="harry";
        graduate.age=22;
        graduate.setScore(89);
        graduate.testing();
        graduate.showInfo();

    }
}
