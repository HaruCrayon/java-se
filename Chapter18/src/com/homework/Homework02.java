package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用Class类的forName方法得到File类的Class对象
 * 在控制台打印File类的所有构造器
 * 通过newInstance的方法创建File对象，并创建 mynew.txt文件
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        //得到File类的Class对象
        Class<?> fileClass = Class.forName("java.io.File");

        System.out.println("===== File类的所有构造器 =====");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //得到指定的构造器 public java.io.File(java.lang.String)
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        //创建File对象实例
        String filePath = "C:\\test_file\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);
        System.out.println(file.getClass());
        //得到createNewFile的方法对象
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file);

        System.out.println("创建文件成功...");
    }
}
