//乘法表

import java.util.Scanner;

public class MulFor02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("输入乘法表的行数:");
        int num = myScanner.nextInt();
        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j*i + " ");
            }
            System.out.print("\n");
        }

    }
}
