package com.test.poly_.polyarr_;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //重写父类的say()方法
    public String say() {
        return "学生\t" + super.say() + " score=" + score;
    }

    //特有方法
    public void study() {
        System.out.println("学生" + getName() + "在写作业");
    }
}
