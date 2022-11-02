package com.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author LiJing
 * @version 1.0
 * InetAddress 类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost= " + localHost);// asd/192.168.1.4

        //2. 根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("asd");
        System.out.println("host1= " + host1);// asd/192.168.1.4

        //3. 根据域名返回 InetAddress对象, 比如 www.baidu.com
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2= " + host2);// www.baidu.com/36.152.44.95

        //4. 通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2对应的ip= " + hostAddress);// 36.152.44.95

        //5. 通过 InetAddress 对象，获取对应的主机名/域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名= " + hostName);// www.baidu.com

    }
}
