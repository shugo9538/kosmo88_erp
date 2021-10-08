package com.kosmo88.logistics_erp.account.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.account.dto.SlipDTO;

public interface SlipService {
	
	// 일반전표 세부내역
	public List<SlipDTO> slipDetailInfo(HttpServletRequest request, HttpServletResponse response);
	
	

}
