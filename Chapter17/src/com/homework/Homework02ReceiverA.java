package com.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LiJing
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        //接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        //拆包
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //回复
        String answer = "";
        if ("四大名著是哪些".equals(s)) {
            answer = "红楼梦、三国演义、水浒传、西游记";
        } else {
            answer = "what";
        }
        data = answer.getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9998);
        socket.send(packet);

        //关闭资源
        socket.close();
    }
}
