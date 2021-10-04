package com.kosmo88.logistics_erp.purchase.dao;

import java.util.List;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEmployeeDTO;
<<<<<<< HEAD
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
=======
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseEstimateListViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertEstimateDTO;
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
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
	
	// 견적서 등록 화면 - 상품 갯수
	public int getItemCnt();
	
	// 견적서 등록 화면 - 상품 리스트
	public List<PurchaseItemDTO> getItemList();
	
	// 견적서 등록 화면 - 담당자 갯수
	public int getEmployeeCnt();
	
	// 견적서 등록 화면 - 담당자 리스트
	public List<PurchaseEmployeeDTO> getEmployeeList();
	
<<<<<<< HEAD
=======
	// 견적서 등록(request) 처리
	public int insertRequest(PurchaseInsertEstimateDTO dto);
	
	
	
	
	
	
	// 견적서 상세페이지(거래처, 담당자 정보)
	public PurchaseEstimateDetailViewDTO getEstimateDetail(int request_id);
	
	// 견적서 상세페이지(상품 정보)
	public List<PurchaseEstimateDetailViewDTO> getEstimateDetailItem(int request_id);
	
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
}