package com.qqclient.view;

import com.qqclient.service.FileClientService;
import com.qqclient.service.MessageClientService;
import com.qqclient.service.UserClientService;
import com.qqclient.utils.Utility;

/**
 * @author LiJing
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {
    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入
    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
//        System.out.println("退出客户端...");
    }

    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("=======欢迎登录网络通信系统=======");
            System.out.println("\t\t 1.登录系统");
            System.out.println("\t\t 9.退出系统");
            System.out.print("请输入你的选择:");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.print("请输入用户号:");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码:");
                    String passwd = Utility.readString(20);

                    if (userClientService.checkUser(userId, passwd)) {
                        System.out.println("\n=======欢迎用户" + userId + "=======");

                        while (loop) {
                            System.out.println("\n=======网络通信系统二级菜单(用户" + userId + ")=======");
                            System.out.println("\t\t 1.显示在线用户列表");
                            System.out.println("\t\t 2.群发消息");
                            System.out.println("\t\t 3.私聊消息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择:");
                            key = Utility.readString(1);

                            switch (key) {
                                case "1":
                                    userClientService.onlineUserList();
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话:");
                                    String s = Utility.readString(100);
                                    messageClientService.sendMessageToAll(userId, s);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号(在线):");
                                    String receiver = Utility.readString(50);
                                    System.out.print("请输入想说的话:");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(userId, receiver, content);
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送给的用户(在线):");
                                    receiver = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(形式 d:\\xx.jpg):");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入把文件发送到对方的路径(形式 d:\\yy.jpg):");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(userId, receiver, src, dest);
                                    break;
                                case "9":
                                    userClientService.logout();
                                    break;
                            }

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else {//登录服务器失败
                        System.out.println("=======登录失败=======");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }

        }
    }
}
