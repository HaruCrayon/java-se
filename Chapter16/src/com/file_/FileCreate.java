package com.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 * 创建文件对象相关构造器和方法
 */
@SuppressWarnings({"all"})
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname) //根据 路径 构建一个File对象
    @Test
    public void create01() {
        String filePath = "C:\\test_file\\news1.txt";
        File file = new File(filePath);
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile 方法，才会真正的在磁盘创建该文件
        try {
            file.createNewFile();
            System.out.println("文件1创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent,String child) //根据 父目录文件+子路径 构建
    @Test
    public void create02() {
        File parentFile = new File("C:\\test_file");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件2创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent,String child) //根据 父目录+子路径 构建
    @Test
    public void create03() {
        String parentPath = "C:\\test_file";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件3创建成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
