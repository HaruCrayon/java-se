package com.test.poly_.polyparameter_;

public class PolyParameter {
    public static void main(String[] args) {
        Manager harry = new Manager("harry", 5000, 20000);
        Worker jack = new Worker("jack", 4000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(harry);
        polyParameter.showEmpAnnual(jack);

        polyParameter.testWork(harry);
        polyParameter.testWork(jack);
    }

    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());//动态绑定机制
    }

    public void testWork(Employee e) {
        if (e instanceof Manager) {
            ((Manager) e).manage();//向下转型
        } else if (e instanceof Worker) {
            ((Worker) e).work();
        } else {
            System.out.println("不做处理");
        }
    }
}
