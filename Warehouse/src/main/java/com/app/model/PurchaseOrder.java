package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "purchaseOrder")
public class PurchaseOrder {

	@Id
	@GeneratedValue(generator = "pid")
	@GenericGenerator(name = "pid", strategy = "increment")
	@Column(name = "pid")
	private Integer poId;

	@Column(name = "ocode")
	private String orderCode;

	@ManyToOne
	@JoinColumn(name = "shipFk")
	private ShipmentType shipmentCode;

	@ManyToOne
	@JoinColumn(name = "venderFk")
	private WhUserType vendor;

	@Column(name = "ref")
	private String refNum;

	@Column(name = "quality")
	private String qualityCheck;

	@Column(name = "status")
	private String poStatus;

	@Column(name = "dscd")
	private String poDsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer poId) {
		super();
		this.poId = poId;
	}

	public PurchaseOrder(Integer poId, String orderCode, ShipmentType shipmentCode, WhUserType vendor, String refNum,
			String qualityCheck, String poStatus, String poDsc) {
		super();
		this.poId = poId;
		this.orderCode = orderCode;
		this.shipmentCode = shipmentCode;
		this.vendor = vendor;
		this.refNum = refNum;
		this.qualityCheck = qualityCheck;
		this.poStatus = poStatus;
		this.poDsc = poDsc;
	}

	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public ShipmentType getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(ShipmentType shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}

	public String getPoDsc() {
		return poDsc;
	}

	public void setPoDsc(String poDsc) {
		this.poDsc = poDsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", orderCode=" + orderCode + ", shipmentCode=" + shipmentCode
				+ ", vendor=" + vendor + ", refNum=" + refNum + ", qualityCheck=" + qualityCheck + ", poStatus="
				+ poStatus + ", poDsc=" + poDsc + "]";
	}

	
}
