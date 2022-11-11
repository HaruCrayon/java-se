package com.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author LiJing
 * @version 1.0
 * 管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //向集合中添加一个线程
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    //根据userId返回线程
    public static ServerConnectClientThread getClientThread(String userId) {
        return hm.get(userId);
    }

    //返回在线用户列表
    public static String getOnlineUser() {
        //遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next() + " ";
        }

        return onlineUserList;
    }

    //将一个线程从集合删除
    public static void removeClientThread(String userId) {
        hm.remove(userId);
    }
}
