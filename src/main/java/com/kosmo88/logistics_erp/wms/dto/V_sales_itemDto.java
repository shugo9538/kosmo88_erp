package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_sales_itemDto")
public class V_sales_itemDto {

	private int request_id;
	private Date begin_date;
	private Date end_date;
	private String state;
	private String employee_id;
	private int client_id;
	private char enabled;
	private int product_list_id;
	private int item_id;
	private String item_name;
	private int quantity;
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
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public char getEnabled() {
		return enabled;
	}
	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}
	public int getProduct_list_id() {
		return product_list_id;
	}
	public void setProduct_list_id(int product_list_id) {
		this.product_list_id = product_list_id;
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
	
	
	@Override
	public String toString() {
		return "V_request_itemDto [request_id=" + request_id + ", begin_date=" + begin_date + ", end_date=" + end_date
				+ ", state=" + state + ", employee_id=" + employee_id + ", client_id=" + client_id + ", enabled="
				+ enabled + ", product_list_id=" + product_list_id + ", item_id=" + item_id + ", item_name=" + item_name
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
	

}
