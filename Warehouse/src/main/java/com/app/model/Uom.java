package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@Column(name="id")
	@GeneratedValue(generator="uom_gen")
	@GenericGenerator(name="uom_gen",strategy="increment")
	private Integer id;
	@Column(name="type")
	private String utype;
	@Column(name="model")
	private String model;
	@Column(name="dsc")
	private String dsc;
	public Uom() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "Uom [id=" + id + ", utype=" + utype + ", model=" + model + ", dsc=" + dsc + "]";
	}
	
	
	

}
