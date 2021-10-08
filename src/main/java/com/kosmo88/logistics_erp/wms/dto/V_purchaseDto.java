package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_purchaseDto")
public class V_purchaseDto {

	int purchase_id;
	int client_id;
	String client_name;
	Date begin_date;
	Date end_date;
	char enabled;
	int item_count;
	String state;
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "V_purchaseDto [purchase_id=" + purchase_id + ", client_id=" + client_id + ", client_name=" + client_name
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + ", enabled=" + enabled + ", item_count="
				+ item_count + ", state=" + state + "]";
	}

	
	
	
	
	

}
