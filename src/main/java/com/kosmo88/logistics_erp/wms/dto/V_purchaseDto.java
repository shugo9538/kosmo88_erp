package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

public class V_purchaseDto {
	int purchase_id;

	int request_id;
	int inbound_id;
	int item_id;
	String item_name;
	int quantity;
	int client_id;
	String client_name;


	Date begin_date;
	Date end_date;
	

	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
	public int getInbound_id() {
		return inbound_id;
	}
	public void setInbound_id(int inbound_id) {
		this.inbound_id = inbound_id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
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
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	@Override
	public String toString() {
		return "V_InboundDto [request_id=" + request_id + ", item_id=" + item_id + ", item_name=" + item_name
				+ ", quantity=" + quantity + ", client_id=" + client_id + ", client_name=" + client_name
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + "]";
	}
	
	

}
