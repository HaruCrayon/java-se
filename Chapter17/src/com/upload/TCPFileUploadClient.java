package com.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author LiJing
 * @version 1.0
 * 文件上传的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //连接服务端8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //读取本地文件
        String filePath = "C:\\test_file\\wb.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //写入数据通道
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        //接收服务端发送的消息，并显示
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭IO流和socket, 先开后关
        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
        System.out.println("退出客户端");

    }
}
