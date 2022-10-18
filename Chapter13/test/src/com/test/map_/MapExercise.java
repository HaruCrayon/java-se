package com.test.map_;

/**
 * @author LiJing
 * @version 1.0
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map接口练习题
 * 使用HashMap添加3个员工对象，要求
 * 键：员工id
 * 值：员工对象
 * <p>
 * 并遍历显示工资>18000的员工(遍历方式最少两种)
 * 员工类：姓名、工资、员工id
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("jack", 23000, 1));
        map.put(2, new Employee("mary", 17000, 2));
        map.put(3, new Employee("smith", 38000, 3));
        map.put(4, new Employee("tom", 12000, 4));

        //第一种遍历方式：keySet 增强for
        System.out.println("方式一：keySet 增强for");
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Employee employee = (Employee) map.get(key);
            if (employee.getSalary() > 18000) {
                System.out.println(employee);
            }
        }

        //第二种遍历方式：entrySet 迭代器
        System.out.println("方式二：entrySet 迭代器");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Employee employee = (Employee) entry.getValue();
            if (employee.getSalary() > 18000) {
                System.out.println(employee);
            }

        }
    }
}

class Employee {
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}