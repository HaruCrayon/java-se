package com.reader_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\test_file\\b.java";
        String line;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
        //关闭流，只需要关闭 BufferedReader，因为底层会自动的去关闭节点流 FileReader
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
    }
}
