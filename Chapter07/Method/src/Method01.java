
public class Method01 {
    public static void main(String[] args) {

        AA a = new AA();
        if(a.isOdd(7)) {
            System.out.println("是奇数");
        } else {
            System.out.println("是偶数");
        }

        a.print(4, 6, '#');
    }
}


class AA {

    //方法：判断一个数是奇数odd 还是偶数, 返回boolean
    public boolean isOdd(int num) {
        return num % 2 != 0;
    }

    //方法：根据行、列、字符打印对应行数和列数的字符
    public void print(int row, int col, char c) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}