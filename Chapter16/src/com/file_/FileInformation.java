package com.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author LiJing
 * @version 1.0
 * 获取文件的相关信息
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        //先创建文件对象
        File file = new File("C:\\test_file\\news1.txt");

        //调用相应的方法，得到对应信息
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件名字=" + file.getName());
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F
    }
}
