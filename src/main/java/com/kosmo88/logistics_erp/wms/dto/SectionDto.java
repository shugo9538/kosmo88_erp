package com.kosmo88.logistics_erp.wms.dto;

import org.apache.ibatis.type.Alias;

@Alias("SectionDto")
public class SectionDto {

	private int id;
	private int warehouse_id;
	private String name;
	private int capacity;
	private int loaded;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "SectionDto [id=" + id + ", warehouse_id=" + warehouse_id + ", name=" + name + ", capacity=" + capacity
				+ ", loaded=" + loaded + "]";
	}
	
	
}
