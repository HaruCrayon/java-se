package com.dao_.test;

import com.dao_.dao.ActorDAO;
import com.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 */
public class TestDAO {
    //测试 ActorDAO对actor表crud操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //1. 查询结果是多行记录
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 2);
//        List<Actor> actors = actorDAO.queryMulti("select * from actor", Actor.class, null);
        System.out.println("===查询多行结果===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2. 查询结果是单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 4);
        System.out.println("===查询单行结果===");
        System.out.println(actor);

        //3. 查询结果是单值
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 6);
        System.out.println("===查询单值结果===");
        System.out.println(o);

        //4. dml 操作: insert, update, delete
        int update = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)", "Smith", "男", "1945-09-23", "1209876");
        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }
}
