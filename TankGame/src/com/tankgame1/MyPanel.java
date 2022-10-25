package com.tankgame1;

import javax.swing.*;
import java.awt.*;

/**
 * @author LiJing
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel {
    //定义我的坦克
    private Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化我的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //绘制坦克，封装成方法 drawTank()
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    /**
     *
     * @param x         坦克的左上角x坐标
     * @param y         坦克的左上角y坐标
     * @param g         画笔
     * @param type      坦克类型
     * @param direct    坦克方向（上下左右）
     */
    public void drawTank(int x, int y, Graphics g, int type, int direct) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0://敌方的坦克
                g.setColor(Color.cyan);
                break;
            case 1://我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，绘制对应形状的坦克
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
//            case 1:

        }
    }
}
