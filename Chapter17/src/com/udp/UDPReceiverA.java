package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LiJing
 * @version 1.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        //接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        //拆包
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();
//        System.out.println(data.length);//1024
        String s = new String(data, 0, length);
        System.out.println(s);

        //回复
        data = "好的".getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.4"), 9998);
        socket.send(packet);

        //关闭资源
        socket.close();
    }
}
