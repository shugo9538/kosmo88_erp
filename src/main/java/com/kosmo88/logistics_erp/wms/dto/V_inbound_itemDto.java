package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("V_inbound_itemDto")
public class V_inbound_itemDto {
	int inbound_id;
	int request_id;
	int warehouse_id;
	String warehouse_name;
	Date begin_date;
	Date end_date;
	String employee_id;
	Date approved_date;
	Date warehoused_date;
	int item_id;
	String item_name;
	int quantity;
	int client_id;
	String client_name;

	
	public int getInbound_id() {
		return inbound_id;
	}
	public void setInbound_id(int inbound_id) {
		this.inbound_id = inbound_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public String getWarehouse_name() {
		return warehouse_name;
	}
	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
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
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public Date getApproved_date() {
		return approved_date;
	}
	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}
	
	public Date getWarehoused_date() {
		return warehoused_date;
	}
	public void setWarehoused_date(Date warehoused_date) {
		this.warehoused_date = warehoused_date;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
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
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	@Override
	public String toString() {
		return "V_inbound_itemDto [inbound_id=" + inbound_id + ", request_id=" + request_id + ", warehouse_id="
				+ warehouse_id + ", warehouse_name=" + warehouse_name + ", begin_date=" + begin_date + ", end_date="
				+ end_date + ", employee_id=" + employee_id + ", approved_date=" + approved_date + ", warehoused_date="
				+ warehoused_date + ", item_id=" + item_id + ", item_name=" + item_name + ", quantity=" + quantity
				+ ", client_id=" + client_id + ", client_name=" + client_name + "]";
	}

}
