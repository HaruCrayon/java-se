package com.test.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */

/*
    添加10个以上的元素(比如String "hello" )，在2号位插入一个元素"张三"，
    获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合，
    要求:使用List的实现类ArrayList完成。
     */
public class ListExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("list=" + list);
        //在2号位插入一个元素"张三"
        list.add(2, "张三");
        System.out.println("list=" + list);
        // 获得第5个元素
        System.out.println("第5个元素=" + list.get(4));
        // 删除第6个元素
        System.out.println("删除第6个元素=" + list.remove(5));
        System.out.println("list=" + list);
        // 修改第7个元素
        list.set(6, "哈哈");
        System.out.println("list=" + list);
        // 使用迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }

    }
}
