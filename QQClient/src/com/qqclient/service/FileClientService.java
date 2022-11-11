package com.qqclient.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author LiJing
 * @version 1.0
 * 发送文件
 */
public class FileClientService {

    public void sendFileToOne(String sender, String receiver, String src, String dest) {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setSrc(src);
        message.setDest(dest);
        message.setSendTime(new Date().toString());

        //读取src到程序 ---> message
        byte[] fileBytes = new byte[(int) new File(src).length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        message.setFileBytes(fileBytes);

        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).
                            getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //提示信息
        System.out.println("\n" + sender + " 给 " + receiver + " 发送文件 " + src + " 到 " + dest);
    }
}
