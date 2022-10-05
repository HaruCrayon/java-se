package com.test.trycatch_;

/**
 * @author LiJing
 * @version 1.0
 */
public class TryCatch01 {
    public static void main(String[] args) {

        //1. 如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块
        //2. 如果异常没有发生，则顺序执行try的代码块，不会进入到catch
        //3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用如下代码- finally
        try {
//            String str = "jack";
            String str = "123";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息=" + e.getMessage());
        } finally {
            System.out.println("finally代码块被执行...");
        }

        System.out.println("程序继续...");

    }
}