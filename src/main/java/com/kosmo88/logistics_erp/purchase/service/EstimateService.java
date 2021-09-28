package com.kosmo88.logistics_erp.purchase.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;

public interface EstimateService {
	
	// 거래처(구매처) 관리 - 거래처 목록
	public List<PurchaseClientDTO> clientList(HttpServletRequest req, HttpServletResponse res);
}
