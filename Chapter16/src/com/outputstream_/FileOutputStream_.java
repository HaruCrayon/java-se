package com.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 使用 FileOutputStream 将数据写到文件中,
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile() {

        String filePath = "C:\\test_file\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //创建 FileOutputStream 对象
            //1. new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容时，是追加到文件后面
//            fileOutputStream = new FileOutputStream(filePath, true);
            fileOutputStream = new FileOutputStream(filePath);
            //写入一个字节
            fileOutputStream.write('H');

            //写入字符串
            String str = "hello,java!";
//            fileOutputStream.write(str.getBytes(), 0, 6);
            fileOutputStream.write(str.getBytes());
            /*
                str.getBytes() 可以把 字符串-> 字节数组 byte[]
                fileOutputStream.write(str.getBytes());
                write(byte[] b, int off, int len) 将len字节从位于偏移量off的指定字节数组写入此文件输出流
             */

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
