package com.app.dao;

import java.util.List;


import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUserType(WhUserType type);
	public void updateWhUserType(WhUserType type);
	public void deleteWhUserType(Integer id);
	public WhUserType getoneWhUserType(Integer id);
	public List<WhUserType> getAllWhUserType();
	public List<WhUserType> getWhUserTypesByUserTypes(String userType);
	public boolean isWhUserTypeConnectedWithItem(Integer id);


}
