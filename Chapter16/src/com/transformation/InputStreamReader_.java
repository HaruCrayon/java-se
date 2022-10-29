package com.transformation;

import java.io.*;

/**
 * @author LiJing
 * @version 1.0
 * 使用 InputStreamReader 转换流 解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流 InputStreamReader, 指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\test_file\\note.txt";
        String charSet = "utf-8";
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk/utf-8
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), charSet);
        //3. 把 InputStreamReader 传入 BufferedReader
//        BufferedReader br = new BufferedReader(isr);

        //将2和3合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                                                                new FileInputStream(filePath), charSet));

        //4. 读取
        String s = br.readLine();
        System.out.println(s);

        //5. 关闭外层流
        br.close();
    }
}
