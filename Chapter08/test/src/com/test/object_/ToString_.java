package com.test.object_;

public class ToString_ {
    public static void main(String[] args) {
        /*
        Object类的toString()源码:
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
        (1)getClass().getName() 类的全类名(包名+类名)
        (2)Integer.toHexString(hashCode()) 将对象的hashCode 值转成16 进制字符串
        */

        Monster monster = new Monster("jack", "程序员", 10000);
//        System.out.println(monster.toString() + "\t" + monster.hashCode());

//        当直接输出一个对象时,toString方法会被默认的调用。
        System.out.println(monster);
    }
}

class Monster {
    private String name;
    private String job;
    private double salary;

    public Monster(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    //重写toString方法, 输出对象的属性
    //使用快捷键即可 alt+insert -> toString
    @Override
    public String toString() {//重写后，一般是把对象的属性值输出，程序员也可以自己定制
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}