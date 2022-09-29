package com.test.single_;

/*
单例模式-懒汉式
 */
public class Single02 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);
    }
}

class Cat {
    private String name;
    //2.定义一个static属性对象
    private static Cat cat;

    //1.将构造器私有化
    private Cat(String name) {
        this.name = name;
    }

    //3.向外提供一个public的static方法，返回对象.
    //4.懒汉式，只有当用户调用getInstance()时，才会返回cat对象。
    //  后面再次调用时，会返回上次创建的cat对象。
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小白");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}