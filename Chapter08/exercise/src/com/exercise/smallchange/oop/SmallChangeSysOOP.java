package com.exercise.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//项目：零钱通
//版本：OOP(面向对象编程)
//此类是实现各个功能：
//1.显示菜单，并可以选择
//2.零钱通明细
//3.收益入账
//4.消费
//5.退出
public class SmallChangeSysOOP {

    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    String key = "";
    //2.零钱通明细
    String details = "------------ 零钱通明细 ------------";
    //3.收益入账
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //4.消费
    String note = "";

    public void mainMenu(){
        do {
            //1.显示菜单，并可以选择
            System.out.println("\n********* 零钱通菜单OOP *********");
            System.out.println("\t\t 1.零钱通明细 ");
            System.out.println("\t\t 2.收益入账 ");
            System.out.println("\t\t 3.消费 ");
            System.out.println("\t\t 4.退出 ");

            System.out.print("请选择(1-4):");
            key = scanner.next();
            switch (key) {
                case "1":
                    this.details();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("=== 输入错误，重新选择 ===");
            }
        } while (loop);

        System.out.println("\n********* 已经退出零钱通 *********");

    }

    public void details(){
        System.out.println(details);
    }

    public void income(){
        System.out.print("收益入账金额:");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("收益入账金额应大于0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void pay(){
        System.out.print("消费金额:");
        money = scanner.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额范围应在0-" + balance);
            return;
        }
        System.out.print("消费说明:");
        note = scanner.next();
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void exit(){
        String choice = "";
        while (true) {
            System.out.println("确认是否退出:y/n");
            choice = scanner.next();
            if (choice.equals("y") || choice.equals("n")) {
                break;
            }
        }
        if (choice.equals("y")) {
            loop = false;
        }
    }

}
