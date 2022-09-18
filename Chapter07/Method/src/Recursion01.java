public class Recursion01 {
    public static void main(String[] args) {
        MyTools tool = new MyTools();
        int num = 5;
        int res = tool.factorial(num);//求num的阶乘
        System.out.println(num + "的阶乘是" + res);

        int n = 8;
        int res2 = tool.fibonacci(n);//求第n个斐波那契数
        if(res2 != -1) {
            System.out.println("第" + n + "个斐波那契数是" + res2);
        }

        int day = 1;
        int peachNum = tool.peach(day);//猴子吃桃子问题
        if(peachNum != -1) {
            System.out.println("第" + day + "天桃子的个数是" + peachNum);
        }
    }
}


class MyTools {
    //n的阶乘
    public int factorial(int n) {
        if(1 == n) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }

    //斐波那契数列 1 1 2 3 5 8 13 21 ...
    public int fibonacci(int n) {
        if(n >= 1) {
            if(1 == n || 2 == n) {
                return 1;
            } else {
                return fibonacci(n-2) + fibonacci(n-1);
            }
        } else {
            System.out.println("要求输入 n>=1 的整数");
            return -1;
        }
    }

    //猴子吃桃子问题：有一堆桃子，每天猴子都吃其中的一半，然后再多吃一个。
    //第10天，想再吃时（即还没吃），发现只有1个桃子了。
    //问题：最初共多少个桃子？
    //分析：后一天个数=(前一天个数/2)-1, 即 前一天个数=(后一天个数+1)*2
    public int peach(int day) {
        if(day >= 1 && day <= 10) {
            if(10 == day) {
                return 1;
            } else {
                return (peach(day + 1) + 1) * 2;
            }
        } else {
            System.out.println("要求输入 1~10 的整数");
            return -1;
        }
    }

}

