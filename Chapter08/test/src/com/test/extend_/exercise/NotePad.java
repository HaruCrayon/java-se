package com.test.extend_.exercise;

//编写NotePad子类，继承Computer类，添加特有属性【颜色color】
public class NotePad extends Computer {
    private String color;

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String printInfo() {
        return getDetails() + " color=" + color;
    }
}
