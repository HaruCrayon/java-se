package com.generic;

/**
 * @author LiJing
 * @version 1.0
 */
public class Generic03 {
    public static void main(String[] args) {

        //特别强调： E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("hello");
        person.show(); //String

        /*
            class Person {
                String s ;

                public Person(String s) {
                    this.s = s;
                }

                public String f() {
                    return s;
                }
            }
         */

        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();//Integer

        /*
            class Person {
                Integer s ;

                public Person(Integer s) {
                    this.s = s;
                }

                public Integer f() {
                    return s;
                }
            }
         */
    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型

class Person<E> {
    E s;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定, 即在编译期间, 就确定E是什么类型

    public Person(E s) {//E可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
    }
}
