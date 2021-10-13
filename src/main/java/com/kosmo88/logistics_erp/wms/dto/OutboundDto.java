package com.kosmo88.logistics_erp.wms.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("OutboundDto")
public class OutboundDto {

	int id;
	int request_id;
	int warehouse_id;
	Date approved_date;
	Date shipped_date;
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
	public Date getApproved_date() {
		return approved_date;
	}
	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}
	public Date getShipped_date() {
		return shipped_date;
	}
	public void setShipped_date(Date shipped_date) {
		this.shipped_date = shipped_date;
	}
	@Override
	public String toString() {
		return "OutboundDto [id=" + id + ", request_id=" + request_id + ", warehouse_id=" + warehouse_id
				+ ", approved_date=" + approved_date + ", shipped_date=" + shipped_date + "]";
	}
	
	


	
}
