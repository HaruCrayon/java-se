package com.test.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LiJing
 * @version 1.0
 */

/*
        案例：自定义Book类，里面包含name和price，有一个 Book[] books = 4本书对象。
        要求使用三种方式排序 ,可以按照 price (1)从大到小 (2)从小到大 (3) 按照书名长度从大到小
        使用前面学习过的传递 实现Comparator接口匿名内部类，也称为定制排序。
         */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("西游记", 78.7);
        books[1] = new Book("格列佛游记", 50);
        books[2] = new Book("三国演义", 30);
        books[3] = new Book("飘", 100.3);

        // (1)按照 price 从小到大
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book) o1;
//                Book b2 = (Book) o2;
//                double priceVal = b1.getPrice() - b2.getPrice();
//                if (priceVal > 0) {
//                    return 1;
//                } else if (priceVal < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });

        // (2)按照 price 从大到小
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book) o1;
//                Book b2 = (Book) o2;
//                double priceVal = b2.getPrice() - b1.getPrice();
//                if (priceVal > 0) {
//                    return 1;
//                } else if (priceVal < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });

        // (3) 按照书名长度从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.getName().length() - b1.getName().length();
            }
        });

        System.out.println(Arrays.toString(books));

    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}