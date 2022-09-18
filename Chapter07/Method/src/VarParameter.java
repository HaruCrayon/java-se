public class VarParameter {
    public static void main(String[] args) {
        T tool = new T();
        String res1 = tool.showScore("小李", 78.9, 86.0);
        String res2 = tool.showScore("小王", 89.0, 70.8, 67.5);
        System.out.println(res1);
        System.out.println(res2);

    }
}


class T {

    public String showScore(String name, double... scores) {
        double totalScore = 0;
        for(int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }

        return name + scores.length + "门课总分是" + totalScore;
    }
}

