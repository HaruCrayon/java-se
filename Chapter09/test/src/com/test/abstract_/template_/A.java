package com.test.abstract_.template_;

public class A extends Template {

    @Override
    public void job() {
        long sum = 0;
        for (long i = 1; i <= 1000000; i++) {
            sum += i;
        }
    }
}
