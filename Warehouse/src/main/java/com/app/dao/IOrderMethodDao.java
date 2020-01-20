package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;
import com.app.model.Uom;

public interface IOrderMethodDao {
	public Integer saveOrderMethod(OrderMethod om);

	public void updateOrderMethod(OrderMethod om);

	public void deleteOrderMethod(Integer id);

	public OrderMethod getoneOrderMethod(Integer id);

	public List<OrderMethod> getAllOrderMethod();

	public List<OrderMethod> getOrderMethodsByMode(String mode);
	
	public boolean isOrderMethodConnectedWithItem(Integer id);
}
