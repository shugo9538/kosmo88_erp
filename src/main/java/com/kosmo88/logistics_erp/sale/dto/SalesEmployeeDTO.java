package com.kosmo88.logistics_erp.sale.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("SalesEmployeeDTO")
public class SalesEmployeeDTO {

	private String id;					// 사원번호
	private String name;				// 사원명
	private String photo;				// 사진
	private String resident_reg_num;	// 주민등록번호
	private String phone;				// 휴대전화
	private String address;				// 주소
	private Date hire_date;				// 입사일
	private String email;				// 이메일
	private String enabled;				// 활성화코드
	private int department_id;			// 부서코드
	private String department_name;		// 부서이름
	private int position_id;			// 직급코드
	
	public SalesEmployeeDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getResident_reg_num() {
		return resident_reg_num;
	}

	public void setResident_reg_num(String resident_reg_num) {
		this.resident_reg_num = resident_reg_num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	
	
}
