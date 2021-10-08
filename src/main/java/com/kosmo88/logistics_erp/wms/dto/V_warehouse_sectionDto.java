package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

@Alias("V_warehouse_sectionDto")
public class V_warehouse_sectionDto {

	int warehouse_id;
	String warehosue_name;
	int section_id;
	String section_name;
	int capacity;
	int loaded;
	int item_id;
	int item_name;
	int count;
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehosue_name() {
		return warehosue_name;
	}
	public void setWarehosue_name(String warehosue_name) {
		this.warehosue_name = warehosue_name;
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
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_name() {
		return item_name;
	}
	public void setItem_name(int item_name) {
		this.item_name = item_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "V_warehouse_sectionDto [warehouse_id=" + warehouse_id + ", warehosue_name=" + warehosue_name
				+ ", section_id=" + section_id + ", section_name=" + section_name + ", capacity=" + capacity
				+ ", loaded=" + loaded + ", item_id=" + item_id + ", item_name=" + item_name + ", count=" + count + "]";
	}
	
	
}
