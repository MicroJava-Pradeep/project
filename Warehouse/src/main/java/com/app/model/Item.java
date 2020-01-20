package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="itemtab")
public class Item {

	@Id
	@GeneratedValue(generator="item_gen")
	@GenericGenerator(name="item_gen",strategy="increment")
	@Column(name="id")
	private Integer id;
	@Column(name="code")
	private String iCode;
	
	@Column(name="width")
	private double wid;
	@Column(name="length")
	private double len;
	@Column(name="hight")
	private double hgt;
	
	
	@Column(name="basecost")
	private double baseCost;
	@Column(name="basecurrency")
	private String baseCurrency;	
	
	@Column(name="description")
	private String dsc;
	
	//Multiplicity
	@ManyToOne
	@JoinColumn(name="uidFK")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="om_saletype")
	private OrderMethod saleType;
	
	@ManyToOne
	@JoinColumn(name="om_pruchasetype")
	private OrderMethod purchaseType;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_ven_types",joinColumns={@JoinColumn(name="itm_fk")},
	inverseJoinColumns={@JoinColumn(name="ven_fk")})
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> venTypes=new ArrayList<WhUserType>(0);
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_cust_types",joinColumns={@JoinColumn(name="itm_fk")},
	inverseJoinColumns={@JoinColumn(name="cust_fk")})
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> custTypes=new ArrayList<WhUserType>(0);
	

	
	public Item() {
		super();
	}
	public Item(Integer id) {
		super();
		this.id = id;
	}
	public Item(Integer id, String iCode, double wid, double len, double hgt, double baseCost, String baseCurrency,
			String dsc, Uom uom, OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> venTypes,
			List<WhUserType> custTypes) {
		super();
		this.id = id;
		this.iCode = iCode;
		this.wid = wid;
		this.len = len;
		this.hgt = hgt;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.dsc = dsc;
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.venTypes = venTypes;
		this.custTypes = custTypes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getiCode() {
		return iCode;
	}
	public void setiCode(String iCode) {
		this.iCode = iCode;
	}
	public double getWid() {
		return wid;
	}
	public void setWid(double wid) {
		this.wid = wid;
	}
	public double getLen() {
		return len;
	}
	public void setLen(double len) {
		this.len = len;
	}
	public double getHgt() {
		return hgt;
	}
	public void setHgt(double hgt) {
		this.hgt = hgt;
	}
	public double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public OrderMethod getSaleType() {
		return saleType;
	}
	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}
	public OrderMethod getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}
	public List<WhUserType> getVenTypes() {
		return venTypes;
	}
	public void setVenTypes(List<WhUserType> venTypes) {
		this.venTypes = venTypes;
	}
	public List<WhUserType> getCustTypes() {
		return custTypes;
	}
	public void setCustTypes(List<WhUserType> custTypes) {
		this.custTypes = custTypes;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", iCode=" + iCode + ", wid=" + wid + ", len=" + len + ", hgt=" + hgt + ", baseCost="
				+ baseCost + ", baseCurrency=" + baseCurrency + ", dsc=" + dsc + ", uom=" + uom + ", saleType="
				+ saleType + ", purchaseType=" + purchaseType + ", venTypes=" + venTypes + ", custTypes=" + custTypes
				+ "]";
	}
	
	
}
