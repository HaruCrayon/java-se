package com.test.list_;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //List 接口的实现子类 ArrayList Vector LinkedList
        //List list = new ArrayList();
        //List list = new Vector();
        List list = new LinkedList();

        list.add("jack");
        list.add("tom");
        list.add("张三");
        list.add("玛丽");

        //遍历
        System.out.println("=====迭代器=====");
        //1. 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

        System.out.println("=====增强for=====");
        //2. 增强for
        for (Object o : list) {
            System.out.println("o=" + o);
        }

        System.out.println("=====普通for====");
        //3. 普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println("obj=" + list.get(i));
        }

    }
}
