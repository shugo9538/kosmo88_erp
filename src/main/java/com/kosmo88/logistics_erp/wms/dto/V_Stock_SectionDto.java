package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

@Alias("V_Stock_SectionDto")
public class V_Stock_SectionDto {

//	stock
	private int stock_id;
	private int item_id;
	private String item_name;
	private int count;

//	section
	private String warehouse_name;

	private int warehouse_id;
	private int section_id;
	private String section_name;
	private int capacity;
	private int loaded;

	public int getStock_id() {
		return stock_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
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

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
	}

	@Override
	public String toString() {
		return "Stock_SectionDto [stock_id=" + stock_id + ", item_id=" + item_id + ", item_name=" + item_name
				+ ", count=" + count + ", warehouse_id=" + warehouse_id + ", section_id=" + section_id
				+ ", section_name=" + section_name + ", capacity=" + capacity + ", loaded=" + loaded + "]";
	}

}
