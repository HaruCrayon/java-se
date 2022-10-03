package com.homework.homework05;

/**
 * @author LiJing
 * @version 1.0
 */
public class Horse implements Vehicles {
    //2.有Horse类和Boat类分别实现Vehicles
    @Override
    public void work() {
        System.out.println("一般情况下，使用马行进");
    }
}
