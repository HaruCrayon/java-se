import java.util.Scanner;

public class SwitchExer02 {
    public static void main(String[] args) {

        //根据月份，打印该月份所属的季节。
        //3,4,5春季 6,7,8夏季 9,10,11秋季 12,1,2冬季 [使用穿透]
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入月份:");
        int month = myScanner.nextInt();
        switch(month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入错误,请输入1~12");
                break;
        }
        System.out.println("结束switch,程序继续...");
    }
}
