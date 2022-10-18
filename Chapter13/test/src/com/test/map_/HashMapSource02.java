package com.test.map_;

import java.util.HashMap;

/**
 * @author LiJing
 * @version 1.0
 * 模拟 HashMap 触发扩容、树化
 */
@SuppressWarnings({"all"})
public class HashMapSource02 {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(new A(i), "hello");
//            hashMap.put(i, "hello");
        }

        hashMap.put("aaa", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v

        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->

    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100
    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
