package com.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiJing
 * @version 1.0
 * 服务端，使用字符流
 */
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");

        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("服务端socket =" + socket.getClass());

        //3. 通过socket.getInputStream() 得到和socket对象关联的输入流对象
        InputStream inputStream = socket.getInputStream();

        //4. IO读取, 读取客户端写入到数据通道的数据, 显示（使用字符流）
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5. 获取和socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //6.关闭IO流和socket  先开后关
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
