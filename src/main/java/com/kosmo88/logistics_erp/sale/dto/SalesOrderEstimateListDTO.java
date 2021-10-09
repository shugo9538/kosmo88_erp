package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

// 영업팀 주문서 등록
@Alias("SalesOrderEstimateListDTO")
public class SalesOrderEstimateListDTO {

	private int request_id;					// 견적번호
	private Date begin_date;				// 요청일자
	private String employee_id;			// 담당자 코드
	private String employee_name;			// 담당자
	private String employee_phone;			// 담당자 연락처
	private String employee_email;  		// 담당자 이메일
	private int department_id;				// 부서코드
	private String department_name;			// 담당자 부서
	private int client_id;					// 거래처 코드
	private String client_name;				// 거래처명
	private String client_zip_code;			// 거래처 우편번호
	private String client_address;  		// 거래처 주소
	private String client_detail_address;  	// 거래처 상세주소
	private String client_ceo_name; 		// 거래처대표자명
	private String client_phone; 			// 거래처연락처
	private String client_email;			// 거래처 이메일
	
	public SalesOrderEstimateListDTO() {}

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

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_phone() {
		return employee_phone;
	}

	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
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

	public String getClient_zip_code() {
		return client_zip_code;
	}

	public void setClient_zip_code(String client_zip_code) {
		this.client_zip_code = client_zip_code;
	}

	public String getClient_address() {
		return client_address;
	}

	public void setClient_address(String client_address) {
		this.client_address = client_address;
	}

	public String getClient_detail_address() {
		return client_detail_address;
	}

	public void setClient_detail_address(String client_detail_address) {
		this.client_detail_address = client_detail_address;
	}

	public String getClient_ceo_name() {
		return client_ceo_name;
	}

	public void setClient_ceo_name(String client_ceo_name) {
		this.client_ceo_name = client_ceo_name;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}

	public String getClient_email() {
		return client_email;
	}

	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}
	
	
}
