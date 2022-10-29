package com.homework;

/**
 * @author LiJing
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * (1) 判断 C:\\test_file 下是否有文件夹mytemp ,如果没有就创建mytemp
 * (2) 在C:\\test_file\\mytemp 目录下, 创建文件 hello.txt
 * (3) 如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
 * (4) 并且在hello.txt 文件中，写入 hello,world~
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:\\test_file\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println(directoryPath + "创建成功");
            } else {
                System.out.println(directoryPath + "创建失败");
            }
        }

        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (file.exists()) {
            System.out.println(file + "已存在,不再重复创建");
        } else {
            if (file.createNewFile()) {
                System.out.println(file + "创建成功");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("hello,你好");
                bw.close();

            } else {
                System.out.println(file + "创建失败");
            }
        }

    }
}
