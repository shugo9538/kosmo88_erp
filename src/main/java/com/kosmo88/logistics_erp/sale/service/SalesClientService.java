package com.kosmo88.logistics_erp.sale.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dao.SalesItemDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesInsertClientDTO;

public interface SalesClientService {

	// 거래처(판매처) 관리 - 거래처 목록
	public List<SalesClientDTO> clientList(HttpServletRequest req, HttpServletResponse res);
	
	// 거래처 등록 처리
	public boolean clientRegisterAction(SalesInsertClientDTO dto);
	
	// 상품 등록 처리
	public boolean itemRegisterAction(SalesItemDTO dto);
	
	// 거래처 상세페이지
	public void clientDetail(HttpServletRequest req, Model model);
	
	// 거래처 삭제(선택삭제)
	public boolean clientChoiceDelete(int[] client_id);
	
	// 거래처 수정페이지
	public void clientUpdate(HttpServletRequest req, Model model);
	
	// 거래처 수정 처리
	public void clientUpdateAction(HttpServletRequest req, Model model);
	
	// 거래처 삭제(상세페이지에서 단일 삭제)
	public void clientDelete(HttpServletRequest req, Model model);
}
