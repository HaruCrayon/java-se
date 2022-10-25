package com.tankgame1;

import javax.swing.*;

/**
 * @author LiJing
 * @version 1.0
 * 坦克大战 1.0 包含的功能：绘制出了我方的坦克
 */
@SuppressWarnings({"all"})
public class TankGame01 extends JFrame {
    private MyPanel mp = null;

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TankGame01();
    }
}
