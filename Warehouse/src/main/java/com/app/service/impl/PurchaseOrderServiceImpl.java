package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		return dao.savePurchaseOrder(po);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
		// TODO Auto-generated method stub
		dao.updatePurchaseOrder(po);;

	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer poId) {
		// TODO Auto-generated method stub
		dao.deletePurchaseOrder(poId);

	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer poId) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrder(poId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrder() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseOrder();
	}

}
