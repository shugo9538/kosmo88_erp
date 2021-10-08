package com.kosmo88.logistics_erp.purchase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertOrderDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

public interface OrderService {
	
	// 구매 관리 - 주문서 목록
	public List<PurchaseOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res);
	
	// 주문서 등록 처리
	public boolean orderRegisterAction(PurchaseInsertOrderDTO dto);
	
	// 주문서 상품 등록 처리
	public boolean itemRegisterAction(PurchaseOrderItemDTO dto);
	
	// 주문서 상세페이지
	public void orderDetail(HttpServletRequest req, Model model);
	
	// 주문서 삭제(선택삭제)
	public boolean orderChoiceDelete(int[] request_id);

	// 주문서 삭제(상세페이지에서 단일 삭제)
	public void orderDelete(HttpServletRequest req, Model model);
	
	// 주문서 등록 화면 - 견적서 선택
	public void selectEstimate(HttpServletRequest req, Model model);
	
	// 견적서 상품 불러오기
	public List<PurchaseOrderItemDTO> orderEstimateItemList(HttpServletRequest req, HttpServletResponse res);
	
	
}
