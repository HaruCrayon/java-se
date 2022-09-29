package com.test.abstract_.template_;

public class B extends Template {

    @Override
    public void job() {
        long num = 1;
        for (long i = 1; i <= 1200000; i++) {
            num *= i;
        }
    }
}
