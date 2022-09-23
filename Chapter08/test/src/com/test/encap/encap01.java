package com.test.encap;

public class encap01 {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("harry potter");
//        person.setAge(126);
//        person.setSalary(3000);
        Person person1 = new Person("harry potter", 126, 3000);
        System.out.println(person1.info());
    }
}


class Person {
    public String name;
    private int age;
    private double salary;

    //提供2个构造器
    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //将构造器和setXxx结合，让数据校验生效
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入数据校验的业务逻辑
        if (name.length() >= 2 && name.length() <= 8) {
            this.name = name;
        } else {
            System.out.println("name长度应为(2-8),设为默认值‘无名’");
            this.name = "无名";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("age应为(1-120),设为默认值18");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "信息为：name=" + name + " age=" + age
                + " salary=" + salary;
    }
}
