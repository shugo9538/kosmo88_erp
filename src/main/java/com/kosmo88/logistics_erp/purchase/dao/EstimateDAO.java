package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;

public interface EstimateDAO {

	// 견적서 관리 - 견적서 목록(구매)
	public List<PurchaseEstimateListViewDTO> getEstimateList();
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public int deleteEstimate(int request_id);
	
}