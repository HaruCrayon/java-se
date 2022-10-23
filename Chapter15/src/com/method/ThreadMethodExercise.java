package com.method;

/**
 * @author LiJing
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);

        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
            Thread.sleep(1000);
        }
    }
}

class T3 implements Runnable {
    private int count;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}