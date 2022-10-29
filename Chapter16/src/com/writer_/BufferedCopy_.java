package com.writer_;

import java.io.*;

/**
 * @author LiJing
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) {
        //1. BufferedReader 和 BufferedWriter 是按照字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc，pdf ], 可能造成文件损坏
        String srcFilePath = "C:\\test_file\\b.java";
        String destFilePath = "C:\\test_file\\b2.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("拷贝完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
