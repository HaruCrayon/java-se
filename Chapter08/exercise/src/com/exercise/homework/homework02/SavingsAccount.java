package com.exercise.homework.homework02;

/*
扩展BankAccount类，
新类SavingsAccount每个月都有利息产生(earnMonthlyInterest方法被调用)，
并且有每月三次免手续费的存款或取款。在earnMonthlyInterest方法中重置交易计数
 */
public class SavingsAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.01;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        //判断是否还可以免手续费
        if (count > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        count--;
    }

    public void earnMonthlyInterest() {
        //每个月初，计算并存入上个月的利息，同时将count=3
        count = 3;
        super.deposit(getBalance() * rate);
    }
}
