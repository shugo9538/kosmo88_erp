package com.kosmo88.logistics_erp.account.vo;

public class SalesSlipVO {
	
//	ID            NOT NULL NUMBER(5)    
//	ACCOUNT_TITLE NOT NULL VARCHAR2(50) 
//	SUPPLY_AMOUNT NOT NULL NUMBER(10)   
//	TAX_AMOUNT    NOT NULL NUMBER(10)   
//	TYPE          NOT NULL VARCHAR2(50) 
//	ABSTRACT      NOT NULL VARCHAR2(50) 
//	SLIP_ID       NOT NULL NUMBER(5)  
	
	private int id;
	private String account_title;
	private int supply_amount;
	private int tax_amount;
	private String type;
	private String Abstract;
	private int slip_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount_title() {
		return account_title;
	}
	public void setAccount_title(String account_title) {
		this.account_title = account_title;
	}
	public int getSupply_amount() {
		return supply_amount;
	}
	public void setSupply_amount(int supply_amount) {
		this.supply_amount = supply_amount;
	}
	public int getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(int tax_amount) {
		this.tax_amount = tax_amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	public int getSlip_id() {
		return slip_id;
	}
	public void setSlip_id(int slip_id) {
		this.slip_id = slip_id;
	}
	

}
