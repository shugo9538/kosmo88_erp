package com.kosmo88.logistics_erp.wms.service;

import java.util.HashMap;
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
import com.kosmo88.logistics_erp.wms.dto.V_stock_detailDto;

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

	// 안쓰는건가????
//	// 해야할것
//	// inbound에 warehoused_date 입력
//	// stock 추가
//	// 빈 섹션을 가져오는 로직이 어딘가에는 있어야한다	
//	@Transactional
//	public void warehousingAction(int waerhouseId, int requestId) {
//		// inbound warehoused 처리
//		inboundDao.updateWarehousedDate(requestId);
//		
//		
//		// 구매 정보를 토대로 재고 정보 작성
//		List<V_request_itemDto> itemDtoList = inboundDao.selectItemList(requestId);
//		//sectionId 배열을 쿼리로 받아올 수도 있지만 일단은 백엔드에셔 처리란다
//		
//		
//
//		for (V_request_itemDto itemDto : itemDtoList) {
//			// stock 등록
//			int maxId = stockDao.selectMaxId();
//			StockDto stockDto = new StockDto();
//			stockDto.setId(maxId);
//			stockDto.setSection_id(0);
//			stockDto.setItem_id(itemDto.getItem_id());
//			stockDto.setCount(itemDto.getQuantity());
//			stockDao.insertStock(stockDto);
//		}
//		inboundDao.updateState(requestId);
//	}

//	public void warehousingAction(Map<String, String[]> paramMap,int requestId) {
//		// 1. inbound.warehoused_date update
//		inboundDao.updateWarehousedDate(requestId);
//		
//		// 2. 구매 정보를 토대로 재고 정보 작성
//		String[] itemIdArr = paramMap.get("itemId");
//		String[] quantityArr = paramMap.get("quantity");
//		String[] sectionIdArr = paramMap.get("section");
//
//		for(int i = 0; i<itemIdArr.length; i++) {
//			int itemId = Integer.parseInt(itemIdArr[i]);
//			int quantity = Integer.parseInt(quantityArr[i]);
//			int sectionId = Integer.parseInt(sectionIdArr[i]);
//			StockDto stockDto = new StockDto();
//			stockDto.setCount(quantity);
//			stockDto.setItem_id(itemId);
//			stockDto.setSection_id(sectionId);
//			stockDao.insertStock(stockDto);
//		}
//
//		// 3. request state => 'TX_INBOUND'
//		inboundDao.updateState(requestId);
//	}

	// 넘어오는 값은 itemId, quantity 두가지이다
	// 재고가 부족할 경우를 생각해서 재귀적으로 사용해야야한다
	public void warehousingAction(Map<String, Object> jsonWarehousingVar) {
		List itemIdArr = (List) jsonWarehousingVar.get("itemId");
		List sectionIdArr = (List) jsonWarehousingVar.get("sectionId");
		List quantityArr = (List) jsonWarehousingVar.get("quantity");
		int requestId = (int) jsonWarehousingVar.get("requestId");

		System.out.println(itemIdArr.getClass().getSimpleName() + " " + itemIdArr);
		System.out.println(sectionIdArr.getClass().getSimpleName() + " " + sectionIdArr);
		System.out.println(quantityArr.getClass().getSimpleName() + " " + quantityArr);
		System.out.println("requetId : " + requestId);

		int itemId;
		int sectionId;
		int quantity;
		for (int i = 0; i < itemIdArr.size(); i++) {
			itemId = Integer.parseInt((String) itemIdArr.get(i));
			sectionId = Integer.parseInt((String) sectionIdArr.get(i));
			quantity = Integer.parseInt((String) quantityArr.get(i));

			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("quantity", quantity);
			paramMap.put("itemId", itemId);
			paramMap.put("sectionId", sectionId);
			stockDao.insertStock(paramMap);

		}
		inboundDao.updateWarehousedDate(requestId);

	}

}
