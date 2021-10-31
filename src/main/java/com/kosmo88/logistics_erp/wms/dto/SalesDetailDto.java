package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("SalesDetailDto")
public class SalesDetailDto {

	private int request_id;
	private Date begin_date;
	private String client_name;
	private int item_id;
	private String item_name;
	private String category;
	private int quantity; 
	private int profit;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public Date getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
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
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "SalesDetailDto [request_id=" + request_id + ", begin_date=" + begin_date + ", client_name="
				+ client_name + ", item_id=" + item_id + ", item_name=" + item_name + ", category=" + category
				+ ", quantity=" + quantity + ", profit=" + profit + "]";
	}
	
	

}
