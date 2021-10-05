package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

public class V_warehouse_simpleDto {

	int warehouse_id;
	String warehouse_name;
	int section_count;
	int capacity_sum;
	int loaded_sum;
	Date register_date;

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
	public int getSection_count() {
		return section_count;
	}
	public void setSection_count(int section_count) {
		this.section_count = section_count;
	}
	public int getCapacity_sum() {
		return capacity_sum;
	}
	public void setCapacity_sum(int capacity_sum) {
		this.capacity_sum = capacity_sum;
	}
	
	public int getLoaded_sum() {
		return loaded_sum;
	}
	public void setLoaded_sum(int loaded_sum) {
		this.loaded_sum = loaded_sum;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "V_warehouseDto [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name
				+ ", section_count=" + section_count + ", capacity_sum=" + capacity_sum + ", loaded_sum=" + loaded_sum
				+ ", register_date=" + register_date + "]";
	}
	
	

}
