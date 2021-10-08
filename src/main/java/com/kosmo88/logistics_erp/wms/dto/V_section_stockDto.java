package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

//보류
@Alias("V_section_stockDto")
public class V_section_stockDto {

//	section
	private int section_id;
	private String section_name;
	private int warehouse_id;
//	private int capacity;

//	stock
	private int stock_id;
	private int count;
	private Date register_date;

//item
	private int item_id;
	private String item_name;
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
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	@Override
	public String toString() {
		return "V_section_stockDto [section_id=" + section_id + ", section_name=" + section_name + ", warehouse_id="
				+ warehouse_id + ", stock_id=" + stock_id + ", count=" + count + ", register_date=" + register_date
				+ ", item_id=" + item_id + ", item_name=" + item_name + "]";
	}
	
	

}
