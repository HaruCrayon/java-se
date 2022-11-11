package com.qqserver.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;
import com.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author LiJing
 * @version 1.0
 */
public class QQServer {
    private ServerSocket ss = null;
    private static HashMap<String, User> validUsers = new HashMap<>();

    static {
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("400", new User("400", "123456"));
        validUsers.put("jack", new User("jack", "123456"));
        validUsers.put("tom", new User("tom", "123456"));
    }

    private boolean checkUser(String userId, String passwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }
        if (!user.getPasswd().equals(passwd)) {
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            System.out.println("服务器在9999端口监听，等待客户端连接...");
            ss = new ServerSocket(9999);
            new Thread(new SendNewsToAllService()).start();

            while (true) {
                Socket socket = ss.accept();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();

                if (checkUser(user.getUserId(), user.getPasswd())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //创建一个线程
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(user.getUserId(), socket);
                    serverConnectClientThread.start();
                    //将该线程加入集合
                    ManageClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);

                } else {
                    System.out.println("用户号=" + user.getUserId() + " 密码=" + user.getPasswd() + " 验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
