package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_stockDto")
public class V_stockDto {

	int warehouse_id;
	int section_id;
	String section;
	int item_id;
	String item_name;
	int sum_count;
	Date min_register_date;
	public int getSection_id() {
		return section_id;
	}
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
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
	public int getSum_count() {
		return sum_count;
	}
	public void setSum_count(int sum_count) {
		this.sum_count = sum_count;
	}
	public Date getMin_register_date() {
		return min_register_date;
	}
	public void setMin_register_date(Date min_register_date) {
		this.min_register_date = min_register_date;
	}
	@Override
	public String toString() {
		return "V_stockDto [section_id=" + section_id + ", section=" + section + ", item_id=" + item_id + ", item_name="
				+ item_name + ", sum_count=" + sum_count + ", min_register_date=" + min_register_date + "]";
	}
	
	
}
