package com.mhl.service;

import com.mhl.dao.BillDAO;
import com.mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

/**
 * @author LiJing
 * @version 1.0
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();

    //编写点餐的方法
    //1. 生成账单
    //2. 需要更新对应餐桌的状态
    //3. 如果成功返回true, 否则返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号
        String billId = UUID.randomUUID().toString();

        //将账单生成到bill表, 要求直接计算账单金额
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0) {
            return false;
        }

        //更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    //查询所有账单
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        Bill bill =
                billDAO.querySingle("select * from bill where diningTableId=? and state = '未结账' limit 0,1", Bill.class, diningTableId);

        return bill != null;
    }

    //完成结账[如果餐桌存在，并且该餐桌有未结账的账单]
    public boolean payBill(int diningTableId, String payMode) {
        //1. 修改bill表
        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);
        if (update <= 0) {
            return false;
        }
        //2. 修改diningTable表
        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }

        return true;
    }
}
