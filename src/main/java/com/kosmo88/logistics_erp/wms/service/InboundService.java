package com.kosmo88.logistics_erp.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchase_productDto;

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
//		inboundDao.insert(dto, maxId);
	}

	public List<V_purchase_productDto> productDtoList(int purchase_id) {
		return inboundDao.selectProductList(purchase_id);
	}

	// ㅇ해야할것
		// 1. inbound 테이블에 값 저장(warehouseid도 저장)
		// 2. request (tx_putchase) enabled => 'N'
	@Transactional
	public void dispatchAction(int warehouseId, int purchaseId) {
		// 구매 정보를 토대로 입하 정보 작성
		V_purchaseDto purchaseDto = inboundDao.selectOne(purchaseId);
		//purchaseDto에 값을 넣어서 전달... 돌려막기....
		int maxId = inboundDao.selectMaxId();
		//
		inboundDao.insert(purchaseDto, maxId+1, warehouseId);
//		inboundDao.insert(purchaseDto);
		inboundDao.disablePurchase(purchaseId);

	}

}
