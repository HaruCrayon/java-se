package com.test.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
        Manager jack = new Manager("jack", 22929, 5000);
        jack.setBonus(20000);
        jack.work();

        CommonEmployee harry = new CommonEmployee("harry", 12345, 4000);
        harry.work();
    }
}
