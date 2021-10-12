package com.kosmo88.logistics_erp.wms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;

@Service
public class InboundService {

	@Autowired
	InboundDao inboundDao;
	@Autowired
	StockDao stockDao;

	public List<V_purchaseDto> manageInbound() {
		return inboundDao.selectList();
	}

//	public void dispatchAction(int inboundId, int warehouseId) {
	public void dispatchAction(V_purchaseDto dto, int warehouseId) {
		int maxId = inboundDao.selectMaxId();

//		inboundDao.insert(dto, maxId ,warehouseId);
//		inboundDao.insert(dto, maxId);
	}

	public List<V_request_itemDto> productDtoList(int purchase_id) {
		return inboundDao.selectItemList(purchase_id);
	}

	// -----------------입고 -------------

	// ㅇ해야할것
	// 1. inbound 테이블에 값 저장(warehouseid도 저장)
	// 2. request (tx_purchase) => tx_receiving
	@Transactional
	public void dispatchAction(int warehouseId, int purchaseId) {
		// 구매 정보를 토대로 입하 정보 작성
		V_purchaseDto purchaseDto = inboundDao.selectOne(purchaseId);
		// purchaseDto에 값을 넣어서 전달... 돌려막기....
		int maxId = inboundDao.selectMaxId();
		//
		inboundDao.insertInbound(purchaseDto, maxId + 1, warehouseId);
		inboundDao.updateState(purchaseId);
	}

	// 해야할것
	// inbound에 warehoused_date 입력
	// stock 추가
	// 빈 섹션을 가져오는 로직이 어딘가에는 있어야한다	
	@Transactional
	public void warehousingAction(int waerhouseId, int requestId) {
		// inbound warehoused 처리
		inboundDao.updateWarehoused(requestId);
		
		
		// 구매 정보를 토대로 재고 정보 작성
		List<V_request_itemDto> itemDtoList = inboundDao.selectItemList(requestId);
		//sectionId 배열을 쿼리로 받아올 수도 있지만 일단은 백엔드에셔 처리란다
		
		

		for (V_request_itemDto itemDto : itemDtoList) {
			// stock 등록
			int maxId = stockDao.selectMaxId();
			StockDto stockDto = new StockDto();
			stockDto.setId(maxId);
			stockDto.setSection_id(0);
			stockDto.setItem_id(itemDto.getItem_id());
			stockDto.setCount(itemDto.getQuantity());
			stockDao.insertStock(stockDto);
		}
		inboundDao.updateState(requestId);
	}

	
	
	@Transactional
	public void warehousingAction(Map<String, String[]> paramMap,int requestId) {
		// inbound warehoused 처리
		inboundDao.updateWarehoused(requestId);
		
		// 구매 정보를 토대로 재고 정보 작성
		String[] itemIdArr = paramMap.get("itemId");
		String[] itemNameArr = paramMap.get("itemName");
		String[] quantityArr = paramMap.get("quantity");
		String[] sectionIdArr = paramMap.get("section");

		
		
		//테스트
		for(int i = 0; i<itemIdArr.length; i++) {
			int itemId = Integer.parseInt(itemIdArr[i]);
			int quantity = Integer.parseInt(quantityArr[i]);
			int sectionId = Integer.parseInt(sectionIdArr[i]);
			StockDto stockDto = new StockDto();
			stockDto.setCount(quantity);
			stockDto.setItem_id(itemId);
			stockDto.setSection_id(sectionId);
			stockDao.insertStock(stockDto);
		}

		inboundDao.updateState(requestId);
	}
}
