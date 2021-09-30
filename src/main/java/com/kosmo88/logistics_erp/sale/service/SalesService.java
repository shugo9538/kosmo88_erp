package com.kosmo88.logistics_erp.sale.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface SalesService {

	// ---------------- 거래처 --------------------------------------------
	// 거래처 등록
	public void clientResister(HttpServletRequest request, Model model);
	
	// 거래처 목록
	public void clientList(HttpServletRequest request, Model model);
	
	// 거래처 상세 정보
	public void clientDetail(HttpServletRequest request, Model model);
	
	// 거래처 수정
	public void updateClient(HttpServletRequest request, Model model);
	
	// 거래처 수정 처리
	public void updateClientAction(HttpServletRequest request, Model model);
	
	// 거래처 삭제
	public void deleteClient(HttpServletRequest request, Model model);
	
	// 거래처 삭제 처리
	public void deleteClientAction(HttpServletRequest request, Model model);
	
	
	// ---------------- 견적서 --------------------------------------------
	// 견적서 등록
	public void estimateResister(HttpServletRequest request, Model model);
	
	// 견적서 목록
	public void estimateList(HttpServletRequest request, Model model);
	
	// 견적서 상세 정보
	public void estimateDetail(HttpServletRequest request, Model model);
	
	// 견적서 수정
	public void updateEstimate(HttpServletRequest request, Model model);
	
	// 견적서 수정 처리
	public void updateEstimateAction(HttpServletRequest request, Model model);
	
	// 견적서 삭제
	public void deleteEstimate(HttpServletRequest request, Model model);
	
	// 견적서 삭제 처리
	
	
	
	
	
	
	// 판매 관리
	
	// 판매 등록
	
	
}