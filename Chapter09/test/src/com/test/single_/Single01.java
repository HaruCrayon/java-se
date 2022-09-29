package com.test.single_;

/*
单例模式-饿汉式
 */
public class Single01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

    }
}

class GirlFriend {
    private String name;
    //2.在类的内部直接创建对象
    private static GirlFriend gf = new GirlFriend("mary");

    //1.将构造器私有化
    private GirlFriend(String name) {
        this.name = name;
    }

    //3.向外提供一个public的static方法，返回对象
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
