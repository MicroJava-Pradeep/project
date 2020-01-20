package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer savePurchaseOrder(PurchaseOrder po);
	public void updatePurchaseOrder(PurchaseOrder po);
	public void deletePurchaseOrder(Integer poId);
	public PurchaseOrder getOnePurchaseOrder(Integer poId);
	public List<PurchaseOrder> getAllPurchaseOrder();
}
