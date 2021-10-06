package com.kosmo88.logistics_erp.sale.dto;

import org.apache.ibatis.type.Alias;

@Alias("SalesInsertEstimateDTO")
public class SalesInsertEstimateDTO {

	private int request_id;						// 견적서 코드	
	private String employee_id;					// 사원번호	
	private int client_id;						// 거래처코드   
	private int item_id;						// 상품코드
	private int request_state;					// 리퀘스트 
	
	public SalesInsertEstimateDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
