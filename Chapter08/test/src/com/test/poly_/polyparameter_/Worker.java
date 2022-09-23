package com.test.poly_.polyparameter_;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("职员" + getName() + " is working");
    }

    public double getAnnual() {
        return super.getAnnual();
    }
}
