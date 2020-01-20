package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType stype);

	public void updateShipmentType(ShipmentType stype);

	public void deleteShipmentType(Integer id);

	public ShipmentType getOneShipmentType(Integer id);

	public List<ShipmentType> getAllShipmentTypes();
	
	public List<ShipmentType> getShipmentTypeByEnbled(String enble);

}
