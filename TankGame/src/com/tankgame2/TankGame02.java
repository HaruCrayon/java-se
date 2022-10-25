package com.tankgame2;

import javax.swing.*;

/**
 * @author LiJing
 * @version 2.0
 * 坦克大战 2.0 包含的功能：1.绘制出了我方的坦克 2.通过按键可以控制我方坦克上下左右移动
 */
@SuppressWarnings({"all"})
public class TankGame02 extends JFrame {
    private MyPanel mp = null;

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TankGame02();
    }
}
