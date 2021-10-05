package com.kosmo88.logistics_erp.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;

@Service
public class InboundService {

	@Autowired
	InboundDao inboundDao;

	public List<V_purchaseDto> manageInbound() {
		return inboundDao.selectList();
	}

//	public void dispatchAction(int inboundId, int warehouseId) {
	public void dispatchAction(V_purchaseDto dto, int warehouseId) {
		int maxId = inboundDao.selectMaxId();
		
//		inboundDao.insert(dto, maxId ,warehouseId);
		inboundDao.insert(dto, maxId);
	}

}
