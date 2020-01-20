package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(po);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		ht.update(po);

	}

	@Override
	public void deletePurchaseOrder(Integer poId) {
		// TODO Auto-generated method stub
		PurchaseOrder po=new PurchaseOrder();
		po.setPoId(poId);
		ht.delete(po);

	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer poId) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, poId);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
