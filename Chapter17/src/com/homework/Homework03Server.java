package com.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiJing
 * @version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在监听9999端口，等待连接...");
        Socket socket = serverSocket.accept();

        String fileName = "";
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            fileName += new String(buf, 0, readLen);
        }
        System.out.println(fileName);

        String downloadFilePath = "";
        if ("消愁".equals(fileName)) {
            downloadFilePath = "src\\消愁.mp3";
        } else {
            downloadFilePath = "src\\无名.mp3";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downloadFilePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("退出服务端");
    }
}
