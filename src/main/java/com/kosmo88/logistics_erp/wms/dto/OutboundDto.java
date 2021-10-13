package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("OutnboundDto")
public class OutboundDto {

	int id;
	int request_id;
	int warehouse_id;
	Date begin_date;
	Date end_date;
	String employee_id;
	String client_id;
	char isapproved;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public char getIsapproved() {
		return isapproved;
	}
	public void setIsapproved(char isapproved) {
		this.isapproved = isapproved;
	}
	@Override
	public String toString() {
		return "OutboundDto [id=" + id + ", request_id=" + request_id + ", warehouse_id=" + warehouse_id
				+ ", begin_date=" + begin_date + ", end_date=" + end_date + ", employee_id=" + employee_id
				+ ", client_id=" + client_id + ", isapproved=" + isapproved + "]";
	}

	
}