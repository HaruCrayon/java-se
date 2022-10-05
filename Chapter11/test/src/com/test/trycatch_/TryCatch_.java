package com.test.trycatch_;

/**
 * @author LiJing
 * @version 1.0
 */
public class TryCatch_ {
    public static void main(String[] args) {
        //快捷键 ctrl + atl + t
        try {
            //代码（可能有异常）
        } catch (Exception e) {
            //捕获到异常
            //1.当异常发生时
            //2.系统将异常封装成 Exception对象e, 传递给catch
            //3.得到异常对象后, 程序员自己进行相应的业务处理
            e.printStackTrace();
            System.out.println(e.getMessage());
            //4.注意: 如果没有发生异常, catch代码块不执行
        } finally {
            //1.不管try代码块是否有异常发生, 始终要执行finally
            //2.所以, 通常将释放资源的代码, 放在finally
        }

    }
}
