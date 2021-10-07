package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;
import java.util.Map;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

public interface EstimateDAO {

	// 견적서 관리 - 견적서 목록(구매)
	public List<PurchaseEstimateListViewDTO> getEstimateList();
	
	// 견적서 관리 - 견적서 삭제(선택삭제)
	public int deleteEstimate(int request_id);
	
	// 견적서 등록 화면 - 거래처 갯수
	public int getClientCnt();
	
	// 견적서 등록 화면 - 거래처 리스트
	public List<PurchaseClientDTO> getClientList();

	// 견적서 등록 화면 - 담당자 갯수
	public int getEmployeeCnt();
	
	// 견적서 등록 화면 - 담당자 리스트
	public List<PurchaseEmployeeDTO> getEmployeeList();
	
	// 거래처 상품 불러오기
	public List<PurchaseItemDTO> getEstimateItemList(int id);
	
	// 견적서 등록(REQUEST input) 처리
	public int insertRequest(Map<String, Object> map);
	
	// 견적서 등록(PRODUCT_GROUP input) 처리
	public int insertProductGroup(Map<String, Object> map);
	
	// 견적서 등록(req_product_list tbl) 처리
	public int insertRPL();
	
	// 견적서 상세페이지(거래처, 담당자 정보)
	public PurchaseEstimateDetailViewDTO getEstimateDetail(int request_id);
	
	// 견적서 상세페이지(상품 정보)
	public List<PurchaseEstimateDetailViewDTO> getEstimateDetailItem(int request_id);
	
}