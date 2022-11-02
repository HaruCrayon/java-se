package com.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author LiJing
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        //装包，发送数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入问题:");
        String question = scanner.next();
        byte[] data = question.getBytes();
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9999);
        socket.send(packet);

        //接收回复
        byte[] bytes = new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        //拆包
        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();

    }
}
