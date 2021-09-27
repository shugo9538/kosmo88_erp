package com.kosmo88.logistics_erp.purchase.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO;

public interface PurchaseService {
	
	// 거래처(구매처) 관리 - 거래처 목록
	public void clientList(HttpServletRequest req, Model model);
	
	// 거래처, 상품등록 처리
	public void RegisterClient(HttpServletRequest req, Model model);
	
	
}
