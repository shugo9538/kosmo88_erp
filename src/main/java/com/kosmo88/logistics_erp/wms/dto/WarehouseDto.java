package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

public class WarehouseDto {
	private int id;
	private String name;
	private String address;
	private Date register_date;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "WarehouseDto [id=" + id + ", name=" + name + ", address=" + address + ", register_date=" + register_date
				+ "]";
	}
	
	
}
