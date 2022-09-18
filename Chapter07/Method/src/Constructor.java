public class Constructor {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Harry", 29);
        System.out.println("p1的信息:name=" + p1.name + " age=" + p1.age);
        System.out.println("p2的信息:name=" + p2.name + " age=" + p2.age);

    }
}


class Person {
    String name;
    int age;

    //第一个无参构造器：利用构造器设置所有人的 age 属性初始值都为18
    public Person() {
        age = 18;
    }

    //第二个带 pName 和 pAge 两个参数的构造器:
    //使得每次创建 Person 对象的同时，初始化对象的 age 属性值和 name 属性值。
    public Person(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

}

