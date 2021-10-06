package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_warehouse_simpleDto")
public class V_warehouse_simpleDto {

	private int warehouse_id;
	private String warehouse_name;
	private int section_count;
	private int capacity_count;
	private int loaded_count;
	private int empty_section_count;
	private Date register_date;
	
	
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


	public int getCapacity_count() {
		return capacity_count;
	}


	public void setCapacity_count(int capacity_count) {
		this.capacity_count = capacity_count;
	}


	public int getLoaded_count() {
		return loaded_count;
	}


	public void setLoaded_count(int loaded_count) {
		this.loaded_count = loaded_count;
	}


	public int getEmpty_section_count() {
		return empty_section_count;
	}


	public void setEmpty_section_count(int empty_section_count) {
		this.empty_section_count = empty_section_count;
	}


	public Date getRegister_date() {
		return register_date;
	}


	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}


	@Override
	public String toString() {
		return "V_warehouse_simpleDto [warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name
				+ ", section_count=" + section_count + ", capacity_count=" + capacity_count + ", loaded_count="
				+ loaded_count + ", empty_section_count=" + empty_section_count + ", register_date=" + register_date
				+ "]";
	}

	

}
