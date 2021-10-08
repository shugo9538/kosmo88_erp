package com.kosmo88.logistics_erp.account.dao;

import java.util.List;

import com.kosmo88.logistics_erp.account.dto.SlipDTO;

public interface SlipDAO {
	
	// 일반전표 - 일반전표 세부내역
	public List<SlipDTO> selectSlipInfo(int slip_id);

}
