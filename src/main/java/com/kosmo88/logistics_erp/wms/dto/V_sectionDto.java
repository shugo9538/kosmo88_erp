package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

//뷰로 사용
@Alias("V_sectionDto")
public class V_sectionDto {

	private int id;
	private int warehouse_id;
	private String warehouse_name;
	private String section;
	private int capacity;
	private int loaded;
	private int stock_count_sum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
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
	public int getStock_count_sum() {
		return stock_count_sum;
	}
	public void setStock_count_sum(int stock_count_sum) {
		this.stock_count_sum = stock_count_sum;
	}
	@Override
	public String toString() {
		return "V_sectionDto [id=" + id + ", warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name
				+ ", section=" + section + ", capacity=" + capacity + ", loaded=" + loaded + ", stock_count_sum="
				+ stock_count_sum + "]";
	}
	

	
}
