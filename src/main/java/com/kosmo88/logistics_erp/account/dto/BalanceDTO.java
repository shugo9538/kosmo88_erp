package com.kosmo88.logistics_erp.account.dto;

public class BalanceDTO {
	
	private String account_name;		//계좌이름
	private String account_bank;		//계좌은행
	private String account_balance;		//계좌잔액
	private String account_number;       //계좌번호
	private String type;                //입금유형
	private String abs;                //적요
	private String transaction_date;  //거래일자
	private int current_balance;  //(입금 + 출금)
	private int next_balance;    //잔액누적 += (입금 + 출금)
	
	
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_bank() {
		return account_bank;
	}
	public void setAccount_bank(String account_bank) {
		this.account_bank = account_bank;
	}
	public String getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abs) {
		this.abs = abs;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(int current_balance) {
		this.current_balance = current_balance;
	}
	public int getNext_balance() {
		return next_balance;
	}
	public void setNext_balance(int next_balance) {
		this.next_balance = next_balance;
	}
	
}
