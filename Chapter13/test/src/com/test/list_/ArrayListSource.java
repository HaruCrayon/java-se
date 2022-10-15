package com.test.list_;

import java.util.ArrayList;

/**
 * @author LiJing
 * @version 1.0
 * ArrayList 的创建和扩容，底层操作机制源码分析
 */

@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {
        //debug 看底层源码
        //注意，Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据，需要做设置.

        //创建ArrayList对象
        //无参构造器
//        ArrayList list = new ArrayList();//第一次10，第二次开始按1.5倍扩容
        //有参数的构造器
        ArrayList list = new ArrayList(8);//指定8，满后，按1.5倍扩容

        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

    }
}
