package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
 * 提供getName的公有方法
 * 创建PrivateTest的类对象，利用Class类对象得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class<PrivateTest> ptClass = PrivateTest.class;
        PrivateTest privateTest = ptClass.newInstance();

        Field name = ptClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest, "jack");
//        System.out.println(name.get(o));

        Method getName = ptClass.getMethod("getName");
        System.out.println(getName.invoke(privateTest));

    }
}

class PrivateTest {
    private String name = "hellokitty";

    //默认无参构造器

    public String getName() {
        return name;
    }
}
