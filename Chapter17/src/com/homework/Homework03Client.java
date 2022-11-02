package com.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author LiJing
 * @version 1.0
 * 下载文件
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要下载的文件名:");
        String downloadFileName = scanner.next();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String filePath = "C:\\test_file\\" + downloadFileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("退出客户端");
    }
}
