import java.util.Random;
import java.util.Scanner;

/*                                                                                                    
猜拳游戏                                                                                            
类Play，设计它的成员变量. 成员方法, 可以电脑猜拳. 电脑每次都会随机生成 0, 1, 2                                                    
0 表示 石头 1 表示剪刀 2 表示 布                                                                                 
并要可以显示玩家的输赢次数（清单）, 假定 玩三次.                                                                          
 */ 

public class MoraGame {
    public static void main(String[] args) {
        Play p = new Play();

        // 创建一个二维数组，用来接收局数、玩家出拳情况以及电脑出拳情况  
        int[][] arr1 = new int[3][3];
        // 创建一个一维数组，用来接收玩家输赢情况  
        String[] arr2 = new String[3];

        Scanner myScanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            // 获取玩家出的拳 
            System.out.print("玩家出拳(0/1/2):");
            int playerGuessNum = myScanner.nextInt();
            p.setPlayerGuessNum(playerGuessNum);
            int playerGuess = p.getPlayerGuessNum();
            arr1[i][1] = playerGuess;

            // 获取电脑出的拳 
            int comGuess = p.getComGuessNum();
            arr1[i][2] = comGuess;

            // 判断输赢
            String res = p.compare();
            p.getWinCount(res);
            arr2[i] = res;
            arr1[i][0] = p.playCount;

            // 对每一局的情况进行输出  
            System.out.println("=========================================");                           
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");                                             
            System.out.println(p.playCount + "\t" + playerGuess + "\t\t" + comGuess + "\t\t" + res);
            System.out.println("=========================================");                          
            
        }
        
        // 对游戏的最终结果进行输出 
        System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");                                             
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + "\t\t");
            }
            System.out.println(arr2[i]);
        }

        System.out.println("玩家一共赢了" + p.winCount + "次");
    }
}


class Play {

    //局数
    int playCount;
    //玩家赢的次数
    int winCount;
    //玩家出拳的类型
    int playerGuessNum;//0 1 2
    //电脑出拳的类型
    int comGuessNum;//0 1 2

    //设置玩家猜拳的数字
    public void setPlayerGuessNum(int playerGuessNum) {
        if(playerGuessNum < 0 || playerGuessNum > 2) {
            //抛出一个异常
            throw new IllegalArgumentException("数字输入错误"); 
        } 
        this.playerGuessNum = playerGuessNum;
    }

    public int getPlayerGuessNum() {

        return playerGuessNum;
    }

    //电脑随机生成猜拳的数字
    public int getComGuessNum() {
        Random r = new Random();
        comGuessNum = r.nextInt(3);//返回 0-2的随机数

        return comGuessNum;
    }

    //判断输赢结果
    public String compare() {
        playCount++;
        if(playerGuessNum == 0 && comGuessNum == 1) {
            return "玩家赢了";
        } else if(playerGuessNum == 1 && comGuessNum == 2) {
            return "玩家赢了";
        } else if(playerGuessNum == 2 && comGuessNum == 0) {
            return "玩家赢了";
        } else if (playerGuessNum == comGuessNum) {
            return "平局";
        } else {
            return "玩家输了";
        }
    }

    //计算玩家赢的次数
    public void getWinCount(String res) {
        if(res == "玩家赢了") {
            winCount++;
        } 
    }
}