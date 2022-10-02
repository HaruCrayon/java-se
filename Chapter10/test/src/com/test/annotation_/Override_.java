package com.test.annotation_;

/**
 * @author LiJing
 * @version 1.0
 * 注解 @Override：限定某个方法，是重写父类方法，该注解只能用于方法
 */
public class Override_ {
    public static void main(String[] args) {

    }
}

class Father {//父类

    public void fly() {
        int i = 0;
        System.out.println("Father fly...");
    }

    public void say() {
    }

}

class Son extends Father {//子类

    //1. @Override 注解放在fly方法上，表示子类的fly方法是重写了父类的fly
    //2. 这里如果没有写 @Override 还是重写了父类fly
    //3. 如果写了@Override注解，编译器就会去检查该方法是否真的重写了父类的方法，
    //   如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    //4. 查看 @Override 注解源码
    //   @interface 表示一个注解类，是jdk5 之后加入的
    /*
            @Target(ElementType.METHOD)//说明只能修饰方法
            @Retention(RetentionPolicy.SOURCE)
            public @interface Override {
            }
     */
    @Override
    public void fly() {
        System.out.println("Son fly....");
    }

    @Override
    public void say() {
    }
}

