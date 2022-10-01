package com.test.interface_;

public class InterfacePoly {
    public static void main(String[] args) {
        //1.多态参数
        //接口类型的变量，可以指向实现了接口的类的对象实例。
//        Usb usb = new Phone();
//        usb = new Camera();

        //2.多态数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if(usbs[i] instanceof Phone){
                ((Phone)usbs[i]).call();
            }
        }

    }
}

interface Usb {
    void work();
}

class Phone implements Usb {

    @Override
    public void work() {
        System.out.println("手机在工作...");
    }

    public void call() {
        System.out.println("手机可以打电话");
    }
}

class Camera implements Usb {

    @Override
    public void work() {
        System.out.println("相机在工作...");
    }
}