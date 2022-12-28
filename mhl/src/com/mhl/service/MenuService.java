package com.mhl.service;

import com.mhl.dao.MenuDAO;
import com.mhl.domain.Menu;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    //查询所有菜品信息
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //根据id查询Menu对象
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id=?", Menu.class, id);
    }
}
