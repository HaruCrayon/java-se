package com.test.list_;

/**
 * @author LiJing
 * @version 1.0
 * 模拟一个简单的双向链表
 */
public class LinkedList_ {
    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node harry = new Node("harry");

        //连接三个结点，形成双向链表
        //jack -> tom -> harry
        jack.next = tom;
        tom.next = harry;
        //harry -> tom -> jack
        harry.pre = tom;
        tom.pre = jack;

        Node first = jack;//让first引用指向jack,就是双向链表的头结点
        Node last = harry; //让last引用指向harry,就是双向链表的尾结点

        //从头到尾进行遍历
        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if (first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        //从尾到头遍历
        System.out.println("====从尾到头遍历====");
        while (true) {
            if (last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

        //链表的添加对象/数据
        //要求 在 tom - harry 之间，插入一个对象 smith

        //1. 先创建一个 Node 结点，name 就是 smith
        Node smith = new Node("smith");
        //下面就把 smith 加入到双向链表了
        smith.next = harry;
        smith.pre = tom;
        harry.pre = smith;
        tom.next = smith;

        //让first 重新指向第一个结点jack
        first = jack;

        System.out.println("===从头到尾进行遍历===");
        while (true) {
            if (first == null) {
                break;
            }
            //输出first 信息
            System.out.println(first);
            first = first.next;
        }

        last = harry; //让last重新指向最后一个结点
        //从尾到头遍历
        System.out.println("====从尾到头遍历====");
        while (true) {
            if (last == null) {
                break;
            }
            //输出last 信息
            System.out.println(last);
            last = last.pre;
        }

    }
}

//定义一个Node 类，Node对象 表示双向链表的一个结点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向后一个结点
    public Node pre; //指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    public String toString() {
        return "Node name=" + item;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                ", pre=" + pre +
//                '}';
//    }
}
