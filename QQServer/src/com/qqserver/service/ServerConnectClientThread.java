package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author LiJing
 * @version 1.0
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {
    private String userId;
    private Socket socket;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.userId = userId;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("服务端和客户端 " + userId + " 保持通信");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //根据message的类型，做相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端请求在线用户列表
                    System.out.println(message.getSender() + "请求在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //构建Message对象
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setReceiver(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    //发送普通消息
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageClientThreads.getClientThread(message.getReceiver()).
                                    getSocket().getOutputStream());
                    oos.writeObject(message);

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    //群发消息
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onlineUserId = iterator.next();
                        if (!onlineUserId.equals(message.getSender())) {
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(ManageClientThreads.getClientThread(onlineUserId).
                                            getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    //发送文件
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageClientThreads.getClientThread(message.getReceiver()).
                                    getSocket().getOutputStream());
                    oos.writeObject(message);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    //客户端退出
                    System.out.println(message.getSender() + " 退出");
                    //将这个客户端对应线程，从集合删除
                    ManageClientThreads.removeClientThread(message.getSender());
                    socket.close();
                    break;//退出线程

                } else {
                    System.out.println("其他类型的message,暂时不处理");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
