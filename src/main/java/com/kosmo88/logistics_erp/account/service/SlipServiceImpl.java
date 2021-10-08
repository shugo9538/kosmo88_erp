package com.kosmo88.logistics_erp.account.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kosmo88.logistics_erp.account.dao.SlipDAO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Service
public class SlipServiceImpl implements SlipService {

	@Autowired
	SlipDAO slipDAO;
	
	@Override
	// 일반전표 세부내역 (승인시 확인)
	public List<SlipDTO> slipDetailInfo(HttpServletRequest request, HttpServletResponse response) {
		int slip_id = Integer.parseInt(request.getParameter("slip_id"));
		return (List<SlipDTO>) slipDAO.selectSlipInfo(slip_id);
	}
		
}	


	
	
	