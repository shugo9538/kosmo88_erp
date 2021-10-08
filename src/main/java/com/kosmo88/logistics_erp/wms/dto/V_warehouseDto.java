package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_warehouseDto")
public class V_warehouseDto {

	private int id;
	private String name;
	private String address;
	private Date register_date;
	
	private int section_count;
	private int used_section_count;
	private int capacity_sum;
	private int loaded_sum;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public int getSection_count() {
		return section_count;
	}
	public void setSection_count(int section_count) {
		this.section_count = section_count;
	}
	public int getUsed_section_count() {
		return used_section_count;
	}
	public void setUsed_section_count(int used_section_count) {
		this.used_section_count = used_section_count;
	}
	public int getCapacity_sum() {
		return capacity_sum;
	}
	public void setCapacity_sum(int capacity_sum) {
		this.capacity_sum = capacity_sum;
	}
	public int getLoaded_sum() {
		return loaded_sum;
	}
	public void setLoaded_sum(int loaded_sum) {
		this.loaded_sum = loaded_sum;
	}
	@Override
	public String toString() {
		return "V_warehouseDto [id=" + id + ", name=" + name + ", address=" + address + ", register_date="
				+ register_date + ", section_count=" + section_count + ", used_section_count=" + used_section_count
				+ ", capacity_sum=" + capacity_sum + ", loaded_sum=" + loaded_sum + "]";
	}
	


	

}
