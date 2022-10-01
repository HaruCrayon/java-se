package com.test.innerclass_;

/**
 * 成员内部类：定义在外部类的成员位置上，没有 static 修饰
 */
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //5.外部其他类，访问成员内部类的2种方式
        // 第一种方式
        // outer08.new Inner08(); 相当于把 new Inner08()当做是outer08成员
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        // 第二种方式
        // 在外部类中，编写一个方法，可以返回 Inner08对象实例
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();

    }
}

class Outer08 { //外部类
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi()方法...");
    }

    //2.可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    public class Inner08 {//成员内部类
        private double sal = 99.8;
        private int n1 = 66;
        public void say() {
            //1.可以直接访问外部类的所有成员，包含私有的
            //6.如果成员内部类的成员和外部类的成员重名，成员内部类访问的话，默认遵循就近原则。
            //可以使用 外部类名.this.属性 来访问外部类的成员。
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的n1=" + Outer08.this.n1);
            hi();
        }
    }
    //方法，返回一个Inner08实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }

    //3.作用域：和外部类的其他成员一样，为整个类体。
    // 比如，在外部类的成员方法中创建成员内部类对象，再调用方法。
    public void t1() {
        //4.外部类--访问--成员内部类的成员
        //先创建成员内部类的对象，再访问成员
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}

