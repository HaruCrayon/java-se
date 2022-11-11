package com.qqserver.frame;

import com.qqserver.service.QQServer;

/**
 * @author LiJing
 * @version 1.0
 * 该类创建 QQServer, 启动后台的服务
 */
public class QQFrame {
    public static void main(String[] args) {
        new QQServer();
    }
}
