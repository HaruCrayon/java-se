package com.test.poly_;

public class PolyExercise {
    public static void main(String[] args) {
        Master tom = new Master("tom");
        Dog dog = new Dog("小白狗");
        Bone bone = new Bone("排骨");
        tom.feed(dog, bone);

//        Animal animal = new Dog("小黄");
//        Food food = new Bone("排骨");
//        animal.getName();
//        food.getName();

        Cat cat = new Cat("小花猫");
        Fish fish = new Fish("黄花鱼");
        tom.feed(cat, fish);

    }
}

