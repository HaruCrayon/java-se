//顺序查找

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[20];
        int findNum = 35;
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100) + 1;//随机生成1-100之间的整数
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < arr.length; i++) {
            if(findNum == arr[i]){
                index = i;
                System.out.println("找到了数字" + findNum + " 下标是" + index);
                break;
            }
            
        }
        if(-1 == index) {
            System.out.println("没找到数字" + findNum);
        }
    }
}

