package com.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author LiJing
 * @version 1.0
 * 目录的操作和文件删除
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    //判断 C:\test_file\news1.txt 是否存在，存在就删除，否则提示不存在
    @Test
    public void m1() {
        String filePath = "C:\\test_file\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
        }
    }

    //判断 C:\test_file\demo01 是否存在，存在就删除，否则提示不存在
    //在java编程中，目录也被当做文件
    @Test
    public void m2() {
        String filePath = "C:\\test_file\\demo01";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }
    }

    //判断 C:\test_file\demo01\a\b\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {
//        String directoryPath = "C:\\test_file\\demo01\\a\\b\\c";
        String directoryPath = "C:\\test_file\\demo02";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "已经存在");
        } else {
            if (file.mkdir()) {//创建一级目录使用mkdir() ，创建多级目录使用mkdirs()
                System.out.println(directoryPath + "创建成功");
            } else {
                System.out.println(directoryPath + "创建失败");
            }
        }
    }
}
