package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.Item;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(om);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		ht.update(om);

	}

	@Override
	public void deleteOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		OrderMethod m=new OrderMethod();
		m.setId(id);
		ht.delete(m);
	}

	@Override
	public OrderMethod getoneOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		// TODO Auto-generated method stub
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		String hql="from "+OrderMethod.class.getName()+
				" where mode=?";
		
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms=(List<OrderMethod>)ht.findByCriteria(
				DetachedCriteria.forClass(OrderMethod.class)
				.add
				   (Restrictions.eq("mode",mode)));
		return oms;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderMethodConnectedWithItem(Integer id) {
		List<Long> rowsCount=
		(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Item.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.or(
				Restrictions.eq("purchaseType.id", id),
				Restrictions.eq("saleType.id", id))));
		return rowsCount.get(0)!=0?true:false;
	}

}
