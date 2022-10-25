package com.tankgame3;

/**
 * @author LiJing
 * @version 1.0
 */
public class Shot implements Runnable {
    int x;
    int y;
    int direct;
    int speed = 1;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            //当子弹移动到面板的边界时，就应该销毁（把启动的shot线程销毁)
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
                System.out.println("射击线程结束");
                break;
            }
        }

    }
}
