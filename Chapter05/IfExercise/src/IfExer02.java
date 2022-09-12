import java.util.Scanner;

public class IfExer02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入分数：");
        int grade = myScanner.nextInt();

        if(grade >= 1 && grade <= 100){
            if(grade >=60 && grade < 80) {
                System.out.println("及格");
            } else if(grade >=80 && grade <=100) {
                System.out.println("优秀");
            } else {
                System.out.println("不及格");
            }
        } else {
            System.out.println("请输入1-100之间的分数");
        }
    }
}
