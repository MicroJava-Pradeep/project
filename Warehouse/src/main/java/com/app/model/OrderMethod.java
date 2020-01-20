package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "otab")
public class OrderMethod {
	@Id
	@GeneratedValue(generator = "order_gen")
	@GenericGenerator(name = "order_gen", strategy = "increment")
	@Column(name = "id")
	private Integer id;

	@Column(name = "mode")
	private String mode;

	@Column(name = "code")
	private String code;

	@Column(name = "method")
	private String method;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "otab_child", joinColumns = @JoinColumn(name = "id"))
	@OrderColumn(name = "pos")
	@Column(name = "data")
	private List<String> accept;
	
	@Column(name = "description")
	private String dsc;

	public OrderMethod() {
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<String> getAccept() {
		return accept;
	}

	public void setAccept(List<String> accept) {
		this.accept = accept;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", mode=" + mode + ", code=" + code + ", method=" + method + ", accept="
				+ accept + ", dsc=" + dsc + "]";
	}

}
