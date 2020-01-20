package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveItem(Item item) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(item);
	}

	@Override
	public void updateItem(Item item) {
		ht.update(item);

	}

	@Override
	public void deleteItem(Integer id) {
		Item item=new Item();
		item.setId(id);
		ht.delete(item);

	}

	@Override
	public Item getOneItem(Integer id) {
		
		return ht.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		
		return ht.loadAll(Item.class);
	}

}
