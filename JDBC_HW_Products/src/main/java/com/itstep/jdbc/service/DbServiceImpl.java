package com.itstep.jdbc.service;

import com.itstep.jdbc.config.DBManager;
import com.itstep.jdbc.model.Item;

import java.util.List;

public class DbServiceImpl implements DbService {
    private DBManager dbManager = new DBManager();
    @Override
    public List<Item> getAllItems() {
        return dbManager.getAllItem();
    }

    @Override
    public void setNewItem(Item item) {
        dbManager.setNewCar(item);
    }

    @Override
    public void deleteItem(Integer id) {
        dbManager.deleteItemById(id);
    }
}
