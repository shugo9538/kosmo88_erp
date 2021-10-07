package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

public interface OrderDAO {

	// 구매 관리 - 발주서 목록(구매)
	public List<PurchaseOrderListViewDTO> getOrderList();
	
	// 구매 관리 - 발주서 삭제(선택삭제)
	public int deleteOrder(int request_id);
	
	// 발주서 상세페이지(거래처, 담당자 정보)
	public PurchaseOrderDetailViewDTO getOrderDetail(int request_id);
	
	// 발주서 상세페이지(상품 정보)
	public List<PurchaseOrderDetailViewDTO> getOrderDetailItem(int request_id);
	
	
	
	
	
}