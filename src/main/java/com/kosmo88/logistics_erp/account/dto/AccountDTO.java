package com.kosmo88.logistics_erp.account.dto;

import java.util.Date;

public class AccountDTO {
	
//	ID                NOT NULL NUMBER(5)    
//	NAME              NOT NULL VARCHAR2(50) 
//	ACCOUNT_NUMBER    NOT NULL VARCHAR2(50) 
//	BANK              NOT NULL VARCHAR2(50) 
//	BALANCE           NOT NULL NUMBER(10)   
//	REGISTER          NOT NULL DATE         
//	ACCOUNT_HOLDER_ID NOT NULL NUMBER(5) 
	
	private int id; 
	private String name;
	private String account_number;
	private String bank;
	private int balance;
	private Date register ;
	private int account_holder_id;
	private String enabled;
	
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	public int getAccount_holder_id() {
		return account_holder_id;
	}
	public void setAccount_holder_id(int account_holder_id) {
		this.account_holder_id = account_holder_id;
	}
	
}
