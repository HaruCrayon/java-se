package com.exercise.homework.homework02;


//在BankAccount类的基础上扩展新类CheckingAccount对每次存款和取款都收取1美元的手续费
public class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
