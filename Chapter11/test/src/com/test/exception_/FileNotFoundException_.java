package com.test.exception_;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LiJing
 * @version 1.0
 */
public class FileNotFoundException_ {
    public static void main(String[] args) {

        try {
            FileInputStream fis;
            fis = new FileInputStream("d:\\aa.jpg");
            int len;
            while ((len = fis.read()) != -1) {
                System.out.println(len);
            }
            fis.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
