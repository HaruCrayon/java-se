package com.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiJing
 * @version 1.0
 * 文件上传的服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //监听 8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接...");
        //等待连接
        Socket socket = serverSocket.accept();

        //读取数据通道中的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //保存到 src\
        String destFilePath = "src\\wb2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);

        //回复客户端 收到图片
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();
        socket.shutdownOutput();

        //关闭IO流和socket, 先开后关
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("退出服务端");
    }
}
