package com.exercise.houserent.view;

import com.exercise.houserent.domain.House;
import com.exercise.houserent.service.HouseService;
import com.exercise.houserent.utils.Utility;

/**
 * HouseView.java <=> 类 [界面层]
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private char key;
    private boolean loop = true;
    private HouseService houseService = new HouseService(2);

    public void mainMenu() {
        do {
            System.out.println("\n********* 房屋出租菜单 *********");
            System.out.println("\t\t1.房屋信息列表 ");
            System.out.println("\t\t2.添加房屋信息 ");
            System.out.println("\t\t3.删除房屋信息 ");
            System.out.println("\t\t4.修改房屋信息 ");
            System.out.println("\t\t5.查找房屋 ");
            System.out.println("\t\t6.退出 ");
            System.out.print("请选择(1-6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    listHouse();
                    break;
                case '2':
                    addHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    findHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入错误,请重新选择");
            }
        } while (loop);
    }

    public void listHouse() {
        System.out.println("********* 房屋信息列表 *********");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
        System.out.println("********* 房屋列表完成 *********");
    }

    public void addHouse() {
        System.out.println("********* 添加房屋信息 *********");
        //编号 房主 电话 地址 月租 状态(未出租/已出租)
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("电话:");
        String phone = Utility.readString(12);
        System.out.print("地址:");
        String address = Utility.readString(16);
        System.out.print("月租:");
        int rent = Utility.readInt();
        System.out.print("状态:");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("********* 房屋添加完成 *********");
        } else {
            System.out.println("********* 房屋添加失败 *********");
        }
    }

    public void delHouse() {
        System.out.println("********* 删除房屋信息 *********");
        System.out.print("要删除的房屋信息编号(-1退出):");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("********* 已放弃删除房屋信息 *********");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("********* 成功删除房屋信息 *********");
            } else {
                System.out.println("********* 房屋编号不存在，删除失败 *********");
            }
        } else {
            System.out.println("********* 已放弃删除房屋信息 *********");
        }
    }

    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        }
    }

    public void findHouse() {
        System.out.println("********* 查找房屋信息 *********");
        System.out.print("要查找的房屋信息编号:");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("********* 要查找的房屋信息不存在 *********");
        }
    }

    public void updateHouse() {
        System.out.println("********* 修改房屋信息 *********");
        System.out.print("要修改的房屋信息编号:");
        int updateId = Utility.readInt();
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("要修改的房屋信息不存在");
            return;
        }
        //编号 房主 电话 地址 月租 状态(未出租/已出租)
        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(16, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("月租(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("********* 房屋信息修改成功 *********");
    }
}


