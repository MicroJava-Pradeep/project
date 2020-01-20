package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom om) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(om);
	}

	@Override
	public void updateUom(Uom om) {
		// TODO Auto-generated method stub
		ht.update(om);

	}

	@Override
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
		Uom om=new Uom();
		om.setId(id);
		ht.delete(om);

	}

	@Override
	public Uom getoneUom(Integer id) {
		// TODO Auto-generated method stub
		
		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	
	public boolean isUomModelExist(String uomModel) {
		List<Long> rowsCount=(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Uom.class).setProjection(Projections.rowCount())
		.add(Restrictions.eq("model", uomModel)));
		return rowsCount.get(0)!=0?true:false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomConnectedWithItem(Integer id) {
		List<Long> rowsCount=
		(List<Long>) ht.findByCriteria(
		DetachedCriteria.forClass(Item.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("uom.id", id)));
		return rowsCount.get(0)!=0?true:false;
	}

}
