package com.kosmo88.logistics_erp.wms.dto;

public class RackDto {

	private int id;
	private int warehouseId;
	private String section; 
	private int sectionNumber; 
	private int capacity;
	private int loaded;
	
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "RackDto [id=" + id + ", warehouseId=" + warehouseId + ", section=" + section + ", sectionNumber="
				+ sectionNumber + ", capacity=" + capacity + ", loaded=" + loaded + "]";
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}

}
