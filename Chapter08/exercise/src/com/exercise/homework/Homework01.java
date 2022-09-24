package com.exercise.homework;

/*
定义一个Person类 {name, age, job}, 初始化Person 对象数组，有3个person对象，
并按照 age 从 大到 小进行排序, 提示，使用冒泡排序
*/
public class Homework01 {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        arr[0] = new Person("jack", 30, "建筑师");
        arr[1] = new Person("scott", 25, "程序员");
        arr[2] = new Person("harry", 40, "会计师");

        System.out.println("排序前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //使用冒泡排序
        Person tmp = null;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getAge() < arr[j + 1].getAge()) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
