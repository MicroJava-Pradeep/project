package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shipmenttype")
public class ShipmentType {
	@Id
	@GeneratedValue(generator="ship_gen")
	@GenericGenerator(name="ship_gen",strategy="increment")
	@Column(name = "sid")
	private Integer id;
	
	@Column(name = "smode")
	private String mode;
	
	@Column(name = "scode")
	private String code;
	
	@Column(name = "senambled")
	private String enabled;
	
	@Column(name = "sgrade")
	private String grade;
	@Column(name = "sdsc")
	private String dsc;

	public ShipmentType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", mode=" + mode + ", code=" + code + ", enabled=" + enabled + ", grade="
				+ grade + ", dsc=" + dsc + "]";
	}

}
