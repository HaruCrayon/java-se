package com.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\test_file\\c.txt";

        //1. new FileWriter(filePath, true) 表示以追加的方式写入
        //2. new FileWriter(filePath) , 表示以覆盖的方式写入
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
        bufferedWriter.write("hello,world!");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello,java!");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,你好!");
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
