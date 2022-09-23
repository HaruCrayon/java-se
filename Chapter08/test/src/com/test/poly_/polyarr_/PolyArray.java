package com.test.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        //要求创建1个Person对象、2个Student对象和2个Teacher对象,
        //统一放在数组中，并调用每个对象say方法
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("mary", 17, 67);
        persons[2] = new Student("smith", 16, 89.5);
        persons[3] = new Teacher("scott", 28, 5000);
        persons[4] = new Teacher("harry", 30, 8000);
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());//动态绑定机制
            if(persons[i] instanceof Student){//类型判断
                Student student = (Student)persons[i];//向下转型
                student.study();
                //((Student)persons[i]).study();
            }else if(persons[i] instanceof Teacher){
                ((Teacher)persons[i]).teach();
            }else if(persons[i] instanceof Person){

            }else{
                System.out.println("你的类型有误,请检查");
            }
        }
    }
}
