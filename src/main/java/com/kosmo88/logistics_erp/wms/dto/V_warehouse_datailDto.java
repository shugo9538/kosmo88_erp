package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

public class V_warehouse_datailDto {

	private int warehouse_id;
	private String warehouse_name;
	private String address;
	private Date register_date;
	
	private int section_id;
	private String section_name;
	private int capacity;
	private int loaded;
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
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
	public int getSection_id() {
		return section_id;
	}
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getLoaded() {
		return loaded;
	}
	public void setLoaded(int loaded) {
		this.loaded = loaded;
	}
	@Override
	public String toString() {
		return "WarehouseDto [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name + ", address="
				+ address + ", register_date=" + register_date + ", section_id=" + section_id + ", section_name="
				+ section_name + ", capacity=" + capacity + ", loaded=" + loaded + "]";
	}
	

}