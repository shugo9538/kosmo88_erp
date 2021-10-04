package com.kosmo88.logistics_erp.account.dto;

import java.util.Date;

public class SlipDTO {
	
	private int id;
	private String type;
	private Date register_date;
	private Date update_date;
	private String state;
	private int department_id;
	private int department_request;
	private String enabled;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getDepartment_request() {
		return department_request;
	}
	public void setDepartment_request(int department_request) {
		this.department_request = department_request;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "SlipDTO [id=" + id + ", type=" + type + ", register_date=" + register_date + ", update_date="
				+ update_date + ", state=" + state + ", department_id=" + department_id + ", department_request="
				+ department_request + ", enabled=" + enabled + "]";
	}
	
}
