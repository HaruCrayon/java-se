package com.outputstream_;

import java.io.*;

/**
 * @author LiJing
 * @version 1.0
 * BufferedOutputStream 和 BufferedInputStream 的使用
 * 可以完成二进制文件拷贝
 */
public class BufferedCopy02 {
    public static void main(String[] args) {

        //字节流可以操作二进制文件，也可以操作文本文件
        String srcFilePath = "C:\\test_file\\wb.png";
        String destFilePath = "C:\\test_file\\wb2.png";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
            System.out.println("拷贝完毕...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
