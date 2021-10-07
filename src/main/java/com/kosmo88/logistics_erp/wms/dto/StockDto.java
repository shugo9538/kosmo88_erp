package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

@Alias("StockDto")
public class StockDto {

	private int id;
	private int warehouse_id;
	private int section_id;
	private int item_id;
	private int count;
	
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
	public int getSection_id() {
		return section_id;
	}
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "StockDto [id=" + id + ", warehouse_id=" + warehouse_id + ", section_id=" + section_id + ", item_id="
				+ item_id + ", count=" + count + "]";
	}
	
	
	

}
