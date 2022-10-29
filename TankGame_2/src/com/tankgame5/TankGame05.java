package com.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author LiJing
 * @version 5.0
 * 坦克大战 5.0 包含的功能：
 * 1.绘制出我方的坦克
 * 2.通过按键可以控制我方坦克上下左右移动
 * 3.我方发射子弹
 * 4.敌方发射子弹
 * 5.击中坦克时，坦克消失并产生爆炸效果
 * 6.敌方坦克自由移动
 * 7.控制坦克在规定的范围移动
 * 8.防止敌人坦克重叠运动
 */
@SuppressWarnings({"all"})
public class TankGame05 extends JFrame {
    MyPanel mp = null;
    Scanner scanner = new Scanner(System.in);

    public TankGame05() {
        System.out.println("请输入选择 1: 新游戏 2: 继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1300, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame 中增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new TankGame05();
    }

}
