package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

public interface OrderDAO {

	// 발주서 관리 - 발주서 목록(구매)
	public List<PurchaseOrderListViewDTO> getOrderList();
	
	// 발주서 관리 - 발주서 삭제(선택삭제)
	public int deleteOrder(int request_id);
	
}