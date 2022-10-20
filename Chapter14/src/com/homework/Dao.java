package com.homework;

import java.util.*;

/**
 * @author LiJing
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Dao<T> {
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
