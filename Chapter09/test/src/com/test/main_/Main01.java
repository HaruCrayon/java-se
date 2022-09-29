package com.test.main_;

public class Main01 {
    //main()方法接收String类型的数组参数
    //在IDEA如何传递参数?
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数=" + args[i]);
        }
    }
}
