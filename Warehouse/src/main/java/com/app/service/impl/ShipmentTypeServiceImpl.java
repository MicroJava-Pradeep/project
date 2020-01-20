package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
@Autowired
private IShipmentTypeDao dao;
	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType stype) {
		
		return dao.saveShipmentType(stype);
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType stype) {
		dao.updateShipmentType(stype);

	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer id) {
		
		return dao.getOneShipmentType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return dao.getAllShipmentTypes();
	}

	@Override
	public List<ShipmentType> getShipmentTypeByEnbled(String enble) {
		// TODO Auto-generated method stub
		return dao.getShipmentTypeByEnbled(enble);
	}

}
