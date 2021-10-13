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
	private int sum_count;
	private int item_id;
	private String item_name;
	
	
	
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
	public int getSum_count() {
		return sum_count;
	}
	public void setSum_count(int sum_count) {
		this.sum_count = sum_count;
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
		return "V_sectionDto [id=" + id + ", warehouse_id=" + warehouse_id + ", warehouse_name=" + warehouse_name
				+ ", section=" + section + ", capacity=" + capacity + ", sum_count=" + sum_count + ", item_id="
				+ item_id + ", item_name=" + item_name + "]";
	}

	
	

	
}
