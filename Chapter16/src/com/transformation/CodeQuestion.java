package com.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 * 中文乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取 C:\test_file\note.txt 文件到程序
        //思路
        //1. 创建字符输入流 BufferedReader [处理流]
        //2. 使用 BufferedReader 对象读取 note.txt
        //3. 默认情况下，读取文件是按照 utf-8 编码

        String filePath = "C:\\test_file\\note.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println(s);

        br.close();
    }
}
