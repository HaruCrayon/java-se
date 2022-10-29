package com.print_;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author LiJing
 * @version 1.0
 * PrintStream（字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("hello,你好");
        out.write("hello你好".getBytes());
        out.close();

        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        //因为print底层使用的是write，所以可以直接调用write进行打印/输出
        /*
             public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */

        //我们可以去修改打印流输出的位置/设备
        //1. 输出修改成到 "C:\test_file\f1.txt"
        //2. "hello, 你好北京~" 就会输出到 C:\test_file\f1.txt
        //3. public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out); // native 方法，修改了out
        //   }

        System.setOut(new PrintStream("C:\\test_file\\f1.txt"));
        System.out.println("上海北京天津,hello");
    }
}
