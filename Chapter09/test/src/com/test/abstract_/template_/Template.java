package com.test.abstract_.template_;

public abstract class Template {

    public abstract void job();

    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("任务用时:" + (end - start));
    }
}
