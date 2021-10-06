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
	int item_id;
	String item_name;
	int quentity;
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
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	@Override
	public String toString() {
		return "V_purchaseDto [purchase_id=" + purchase_id + ", client_id=" + client_id + ", client_name=" + client_name
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + ", item_id=" + item_id + ", item_name="
				+ item_name + ", quentity=" + quentity + "]";
	}
	
	
	

}
