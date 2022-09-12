public class For01 {
    public static void main(String[] args) {

        int start = 1;
        int end =100;
        int count = 0;
        int sum = 0;
        int t = 9;
        for(int i = start; i <= end; i++) {
            if(i % t == 0) {
                System.out.println("i=" + i);
                count++;
                sum += i;
            }
        }
        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
    }
}
