package com.exercise.homework.homework02;

public class HomeWork02 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(200);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(199);
//        System.out.println(checkingAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(100);
        savingsAccount.deposit(200);
        savingsAccount.withdraw(300);
        System.out.println(savingsAccount.getBalance());

    }
}
