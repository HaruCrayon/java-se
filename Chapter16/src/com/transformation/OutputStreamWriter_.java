package com.transformation;

import java.io.*;

/**
 * @author LiJing
 * @version 1.0
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\test_file\\note2.txt";
        String charSet = "utf-8";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hello,你好,北京");

        osw.close();
        System.out.println("按照" + charSet + "保存文件成功");

    }
}
