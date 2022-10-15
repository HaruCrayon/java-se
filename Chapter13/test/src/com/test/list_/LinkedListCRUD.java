package com.test.list_;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author LiJing
 * @version 1.0
 * LinkedList 底层结构 源码分析
 */

@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList=" + linkedList);

        //删除某个结点对象
//        linkedList.remove(); // 无参 默认删除的是第一个结点
        linkedList.remove(2);

        System.out.println("linkedList=" + linkedList);

        //修改某个结点对象
        linkedList.set(1,99);
        System.out.println("linkedList=" + linkedList);

        //得到某个结点对象
        //get(1) 是得到双向链表的第二个对象
        Object o = linkedList.get(1);
        System.out.println(o);//999

        //因为LinkedList 是 实现了List接口, 遍历方式
        System.out.println("===LinkeList遍历 迭代器====");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);
        }

        System.out.println("===LinkeList遍历 增强for====");
        for (Object obj : linkedList) {
            System.out.println("obj=" + obj);
        }

        System.out.println("===LinkeList遍历 普通for====");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
    }
}
