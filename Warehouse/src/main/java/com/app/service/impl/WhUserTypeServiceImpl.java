package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType type) {
		// TODO Auto-generated method stub
		return dao.saveWhUserType(type);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType type) {
		// TODO Auto-generated method stub
		dao.updateWhUserType(type);
	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteWhUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getoneWhUserType(Integer id) {
		// TODO Auto-generated method stub
		return dao.getoneWhUserType(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserType() {
		// TODO Auto-generated method stub
		return dao.getAllWhUserType();
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getWhUserTypesByUserTypes(String userType) {
		return dao.getWhUserTypesByUserTypes(userType);
	}

	@Override
	public boolean isWhUserTypeConnectedWithItem(Integer id) {
		// TODO Auto-generated method stub
		return dao.isWhUserTypeConnectedWithItem(id);
	}

}
