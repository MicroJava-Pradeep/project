package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;
	

	@Override
	public Integer saveShipmentType(ShipmentType stype) {
		
		return (Integer)ht.save(stype);
	}

	@Override
	public void updateShipmentType(ShipmentType stype) {
		ht.update(stype);

	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType stype=new ShipmentType();
		stype.setId(id);
		ht.delete(stype);

	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public List<ShipmentType> getShipmentTypeByEnbled(String enble) {
		// TODO Auto-generated method stub
/*		String hql="from "+ShipmentType.class.getName()+" where enabled=?";
*/		@SuppressWarnings("unchecked")
List<ShipmentType> list=(List<ShipmentType>) ht.findByCriteria(
				DetachedCriteria.forClass(ShipmentType.class).add(Restrictions.eq("enabled", enble)));
		return list;
	}

}
