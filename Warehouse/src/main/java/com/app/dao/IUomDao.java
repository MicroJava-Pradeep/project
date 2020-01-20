package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {
	
	public Integer saveUom(Uom om);
	public void updateUom(Uom om);
	public void deleteUom(Integer id);
	public Uom getoneUom(Integer id);
	public List<Uom> getAllUom();
	public boolean isUomModelExist(String uomModel);
	public boolean isUomConnectedWithItem(Integer id);

}
