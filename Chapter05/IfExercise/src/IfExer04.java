import java.util.Scanner;

public class IfExer04 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入成绩：");
        double score = myScanner.nextDouble();

        if(score > 8.0){
            System.out.print("输入性别：");
            char gender = myScanner.next().charAt(0);
            if(gender == '男') {
                System.out.println("进入男子组");
            } else if(gender == '女') {
                System.out.println("进入女子组");
            } else {
                System.out.println("性别输入错误，重新输入");
            } 
        } else {
            System.out.println("淘汰");
        }
    }
}

