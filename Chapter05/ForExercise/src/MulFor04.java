//打印空心菱形

public class MulFor04 {
    public static void main(String[] args) {
        int totalLevel = 6;
        for(int i = 1; i <= totalLevel; i++) {
            for(int k = 1; k <= totalLevel-i; k++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1; j++) {
                if(j == 1 || j == 2*i-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }

        for(int i = 1; i <= totalLevel-1; i++) {
            for(int k = 1; k <= i; k++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*(totalLevel-i)-1; j++) {
                if(j == 1 || j == 2*(totalLevel-i)-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}

