import java.util.Scanner;

public class IfExer03 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入月份：");
        int month = myScanner.nextInt();
        System.out.print("输入年龄：");
        int age = myScanner.nextInt();
        int ticketPrice = 0;

        if(month >= 4 && month <= 10){
            if(age >=18 && age <= 60) {
                ticketPrice = 60;
            } else if(age < 18) {
                ticketPrice = 30;
            } else {
                ticketPrice = 20;
            }
        } else {
            if(age >=18 && age <= 60) {
                ticketPrice = 40;
            } else {
                ticketPrice = 20;
            }
        }
        System.out.println("票价=" + ticketPrice);
    }
}
