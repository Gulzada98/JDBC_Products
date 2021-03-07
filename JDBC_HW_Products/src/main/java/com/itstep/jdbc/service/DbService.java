package com.itstep.jdbc.service;

import com.itstep.jdbc.model.Item;

import java.util.List;

public interface DbService {
    List<Item> getAllItems();
    void setNewItem(Item item);
    void deleteItem(Integer id);
}
