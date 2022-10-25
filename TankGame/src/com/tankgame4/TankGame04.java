package com.tankgame4;

import javax.swing.*;

/**
 * @author LiJing
 * @version 4.0
 * 坦克大战 4.0 包含的功能：
 * 1.绘制出我方的坦克
 * 2.通过按键可以控制我方坦克上下左右移动
 * 3.我方发射子弹
 * 4.敌方发射子弹
 * 5.击中坦克时，坦克消失并产生爆炸效果
 * 6.敌方坦克自由移动
 * 7.控制坦克在规定的范围移动
 */
@SuppressWarnings({"all"})
public class TankGame04 extends JFrame {
    private MyPanel mp = null;

    public TankGame04() {
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TankGame04();
    }
}
