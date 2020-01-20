package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {

	public Integer saveItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Integer id);
	public Item getOneItem(Integer id);
	public List<Item> getAllItems();
	
}
