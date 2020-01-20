package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.Item;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;	
	@Override
	public Integer saveWhUserType(WhUserType type) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(type);
	}

	@Override
	public void updateWhUserType(WhUserType type) {
		// TODO Auto-generated method stub
		ht.update(type);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		// TODO Auto-generated method stub
		WhUserType t=new WhUserType();
		t.setId(id);
		ht.delete(t);
	}

	@Override
	public WhUserType getoneWhUserType(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {
		// TODO Auto-generated method stub
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public List<WhUserType> getWhUserTypesByUserTypes(String userType) {
/*		String hql="from "+WhUserType.class.getName()+" where type=?";
*/		
		List<WhUserType> list=(List<WhUserType>) ht.findByCriteria(
				DetachedCriteria.forClass(WhUserType.class)
				.add(Restrictions.eq("type", userType)));
		return list;
		
	}

	@Override
	public boolean isWhUserTypeConnectedWithItem(Integer id) {
			@SuppressWarnings("unchecked")
			List<Long> rowscount=
			(List<Long>) ht.findByCriteria(
			DetachedCriteria.forClass(Item.class)
			.setProjection(Projections.rowCount())
			.add(Restrictions.or(
					Restrictions.eq("venTypes", id),
					 Restrictions.eq("custTypes",id))));
		return rowscount.get(0)!=0?true:false;
	}

}
