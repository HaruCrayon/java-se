import java.util.Scanner;

public class SwitchExer01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入字符(a~g):");
        char ch = myScanner.next().charAt(0);
        String str = "星期一";
        switch (ch) {
            case 'a': {
                str = "星期一";
                break;
            }
            case 'b': {
                str = "星期二";
                break;
            }
            case 'c': {
                str = "星期三";
                break;
            }case 'd': {
                str = "星期四";
                break;
            }case 'e': {
                str = "星期五";
                break;
            }
            case 'f': {
                str = "星期六";
                break;
            }
            case 'g': {
                str = "星期日";
                break;
            }
            default: {
                str = "输入错误";
                break;
            }
        }
        System.out.println(str);
        System.out.println("退出switch,程序继续...");
    }
}
