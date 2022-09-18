public class This01 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("小白", 2);
        System.out.println("dog1的hashCode=" + dog1.hashCode());
        dog1.info();

        Dog dog2 = new Dog("小黄", 4);
        System.out.println("dog2的hashCode=" + dog2.hashCode());
        dog2.info();
    }
}


class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name =name;
        this.age = age;
        System.out.println("this.hashCode=" + this.hashCode());
    }

    public void info() {
        System.out.println("this.hashCode=" + this.hashCode());
        System.out.println("name=" + name + " age=" + age);
    }
}

