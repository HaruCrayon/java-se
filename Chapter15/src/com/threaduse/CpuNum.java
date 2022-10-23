package com.threaduse;

/**
 * @author LiJing
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前计算机的cpu数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前计算机的cpu个数=" + cpuNums);


    }
}
