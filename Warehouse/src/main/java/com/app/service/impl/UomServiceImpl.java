package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService{

	@Autowired
	private IUomDao dao;
	@Override
	@Transactional
	public Integer saveUom(Uom om) {
		// TODO Auto-generated method stub
		return dao.saveUom(om);
	}

	@Override
	@Transactional
	public void updateUom(Uom om) {
		// TODO Auto-generated method stub
		dao.updateUom(om);
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteUom(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Uom getoneUom(Integer id) {
		// TODO Auto-generated method stub
		return dao.getoneUom(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return dao.getAllUom();
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomModelExist(String uomModel) {
		// TODO Auto-generated method stub
		return dao.isUomModelExist(uomModel);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomConnectedWithItem(Integer id) {
		return dao.isUomConnectedWithItem(id);
	}

}
