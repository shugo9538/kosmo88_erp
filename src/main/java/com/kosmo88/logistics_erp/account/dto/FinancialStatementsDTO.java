package com.kosmo88.logistics_erp.account.dto;

public class FinancialStatementsDTO {
	
		//당좌자산
		private int cash_asets;// 현금및 현금성자산(보통예금포함)	
		private int accounts_receivable;//매출채권(외상매출금)
		private int vatPayment;//부가세대급금
		//재고자산
		private int inventory_assets;//상품
		//부채
		private int purchase_receivable; //매입채권(외상매입금)
		private int vatDeposit;//부가세예수금
		private int capital; //자본금
		
		
		public int getCash_asets() {
			return cash_asets;
		}
		public void setCash_asets(int cash_asets) {
			this.cash_asets = cash_asets;
		}
		public int getAccounts_receivable() {
			return accounts_receivable;
		}
		public void setAccounts_receivable(int accounts_receivable) {
			this.accounts_receivable = accounts_receivable;
		}
		public int getVatPayment() {
			return vatPayment;
		}
		public void setVatPayment(int vatPayment) {
			this.vatPayment = vatPayment;
		}
		public int getInventory_assets() {
			return inventory_assets;
		}
		public void setProductSales(int inventory_assets) {
			this.inventory_assets = inventory_assets;
		}
		public int getPurchase_receivable() {
			return purchase_receivable;
		}
		public void setPurchase_receivable(int purchase_receivable) {
			this.purchase_receivable = purchase_receivable;
		}
		public int getVatDeposit() {
			return vatDeposit;
		}
		public void setVatDeposit(int vatDeposit) {
			this.vatDeposit = vatDeposit;
		}
		public int getCapital() {
			return capital;
		}
		public void setCapital(int capital) {
			this.capital = capital;
		}



}
