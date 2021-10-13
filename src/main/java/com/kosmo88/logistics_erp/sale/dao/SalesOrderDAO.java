package com.kosmo88.logistics_erp.sale.dao;

import java.util.List;
import java.util.Map;

import com.kosmo88.logistics_erp.sale.dto.SalesOrderDetailViewDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderEstimateListDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderItemDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesOrderListViewDTO;


public interface SalesOrderDAO {

	// 주문서 목록
	public List<SalesOrderListViewDTO> getOrderList();
	
	// 주문서 삭제(선택삭제)
	public int deleteOrder(int request_id);
	
	// 주문서 상세페이지(거래처, 담당자 정보)
	public SalesOrderDetailViewDTO getOrderDetail(int request_id);
	
	// 주문서 상세페이지(상품 정보)
	public SalesOrderDetailViewDTO getOrderDetailItem(int request_id);
	
	// 견적서 갯수
	public int getEstimateCnt();
	
	// 견적서 리스트
	public List<SalesOrderEstimateListDTO> getEstimateList();
	
	// 견적서 상품 불러오기
	public List<SalesOrderItemDTO> getOrderEstimateItemList(int id);
	
	// 주문서 등록(REQUEST input) 처리
	public int insertRequest(Map<String, Object> map);
	
	// 주문서(전표) 등록(slip tbl) 처리
	public int insertSlip(Map<String, Object> map);
	
	// 주문서 등록(PRODUCT_GROUP tbl) 처리
	public int insertProductGroup(Map<String, Object> map);
	
	// 주문서 등록(REQ_PRODUCT_LIST) 처리
	public int insertRPL();
	
	// 주문 승인 요청
	public int requestApproval(int id);
}
