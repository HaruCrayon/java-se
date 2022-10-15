package com.test.list_;

import java.util.Vector;

/**
 * @author LiJing
 * @version 1.0
 * Vector 的创建和扩容，底层操作机制源码分析
 */
public class VectorSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //无参构造器
//        Vector vector = new Vector();//默认10，满后，按2倍扩容
        //有参数的构造器
        Vector vector = new Vector(8);//指定8，满后，按2倍扩容

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("vector=" + vector);
    }
}
