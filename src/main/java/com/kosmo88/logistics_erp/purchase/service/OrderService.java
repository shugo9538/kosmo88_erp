package com.kosmo88.logistics_erp.purchase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;

public interface OrderService {
	
	// 구매 관리 - 발주서 목록
	public List<PurchaseOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res);
/*	
	// 발주서 등록 처리
	public boolean orderRegisterAction(PurchaseInsertOrderDTO dto);
	
	// 상품 등록 처리
	public boolean itemRegisterAction(PurchaseItemDTO dto);
	
	// 발주서 상세페이지
	public void orderDetail(HttpServletRequest req, Model model);
	
	// 발주서 삭제(선택삭제)
	public boolean orderChoiceDelete(int[] request_id);
	
	// 발주서 수정페이지
	public void orderUpdate(HttpServletRequest req, Model model);
	
	// 발주서 수정 처리
	public void orderUpdateAction(HttpServletRequest req, Model model);
	
	// 발주서 삭제(상세페이지에서 단일 삭제)
	public void orderDelete(HttpServletRequest req, Model model);
*/	
}
