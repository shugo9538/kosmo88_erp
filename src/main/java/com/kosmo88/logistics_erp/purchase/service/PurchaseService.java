package com.kosmo88.logistics_erp.purchase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;

public interface PurchaseService {
	
	// 거래처(구매처) 관리 - 거래처 목록
	public List<PurchaseClientDTO> clientList(HttpServletRequest req, HttpServletResponse res);
	
	// 거래처, 상품등록 처리
	public boolean clientRegisterAction(HttpServletRequest req, HttpServletResponse res);
	
	// 거래처 상세페이지
	public void clientDetail(HttpServletRequest req, Model model);
	
	// 거래처 삭제(선택삭제)
	public void clientChoiceDelete(HttpServletRequest req, Model model);
	
	// 거래처 수정페이지
	public void clientUpdate(HttpServletRequest req, Model model);
	
	// 거래처 수정 처리
	public void clientUpdateAction(HttpServletRequest req, Model model);
	
	// 거래처 삭제(상세페이지에서 단일 삭제)
	public void clientDelete(HttpServletRequest req, Model model);
}
