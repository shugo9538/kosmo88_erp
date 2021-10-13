package com.kosmo88.logistics_erp.wms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.OutboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;

@Service
public class OutboundService {
	
	@Autowired
	OutboundDao outboundDao;

	public ArrayList<V_outboundDto> shippingStatusList() {
		return (ArrayList<V_outboundDto>) outboundDao.select();
	}

	public List<V_salesDto> manageOutbound() {
		return null;
	}

	//출하 지시 
	//해야할것 
	//1. outbound 테이블ㄷ에 값 저장 
	//2. request (rx_sales => rx_outbound)
	public void dispatchAction(int warehouseId, int requestId) {
		V_salesDto salesDto = outboundDao.selectOne(requestId);
		// salesDto에 값을 넣어서 전달... 돌려막기....
		int maxId = outboundDao.selectMaxId();
		//
		outboundDao.insertOutbound(salesDto, maxId + 1, warehouseId);
		outboundDao.updateState(requestId);
	}

}
