package com.test.interface_;

public class Interface01 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        test(mysqlDB);

        System.out.println("============");

        OracleDB oracleDB = new OracleDB();
        test(oracleDB);
    }

    public static void test(DBInterface db){
        db.connect();
        db.close();
    }
}
