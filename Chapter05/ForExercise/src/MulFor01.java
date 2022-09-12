//统计3 个班成绩情况，每个班有5 名同学，
//求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
//统计三个班及格人数，每个班有5 名同学。

import java.util.Scanner;

public class MulFor01 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int classNum = 3;
        int stuNum = 5;
        double totalScore = 0;
        int passNum = 0;

        for(int i = 1; i <= classNum; i++){
            double sum = 0;
            for(int j = 1; j <= stuNum; j++) {
                System.out.print("输入" + i + "班第" + j + "个学生的成绩:");
                double score = myScanner.nextDouble();
                if(score >= 60) {
                    passNum++;
                }
                sum += score;
            }
            System.out.println(i + "班总分=" + sum + " 平均分=" + (sum/stuNum));
            totalScore += sum;
        }

        System.out.println("所有班级总分=" + totalScore 
            + " 平均分=" + (totalScore/(classNum*stuNum))
            + " 及格人数=" + passNum);
    }
}
