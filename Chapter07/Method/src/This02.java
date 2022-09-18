public class This02 {
    public static void main(String[] args) {
        Student stu1 = new Student("小王", 20);
        Student stu2 = new Student("小李", 20);

        boolean res = stu1.compareTo(stu2);
        System.out.println("stu1和stu2比较的结果是:" + res);

    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //名字和年龄完全一样，就返回true, 否则返回false
    public boolean compareTo(Student stu) {
        return this.name.equals(stu.name) && this.age == stu.age;
    }
}

