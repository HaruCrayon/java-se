package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

import java.io.*;

/**
 * 要求: 使用BufferedReader读取一个文本文件(utf-8编码)，为每行加上行号，再连同内容一并输出到屏幕上。
 * 默认是按照 utf-8处理，所以没有乱码
 * <p>
 * 如果把文件编码改成 gbk，出现中文乱码，如何解决
 * 使用转换流 FileInputStream -> InputStreamReader（可以指定编码） -> BufferedReader
 */
public class Homework02 {
    public static void main(String[] args) {
        String filePath = "C:\\test_file\\a.txt";
        BufferedReader br = null;
        String line = "";
        int lineNum = 0;
        String charSet = "gbk";

        try {
//            br = new BufferedReader(new FileReader(filePath));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charSet));
            while ((line = br.readLine()) != null) {
                System.out.println(++lineNum + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
