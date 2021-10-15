package com.kosmo88.logistics_erp.wms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.OutboundDao;
import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;
import com.kosmo88.logistics_erp.wms.dto.V_stock_detailDto;

@Service
public class OutboundService {

	@Autowired
	OutboundDao outboundDao;
	@Autowired
	StockDao stockDao;

	public ArrayList<V_outboundDto> shippingStatusList() {
		return (ArrayList<V_outboundDto>) outboundDao.select();
	}

	public List<V_salesDto> manageOutbound() {
		return null;
	}

	// 출하 지시
	// 해야할것
	// 1. outbound 테이블ㄷ에 값 저장
	// 2. request (rx_sales => rx_outbound)
	public void dispatchAction(int warehouseId, int requestId) {
		V_salesDto salesDto = outboundDao.selectOne(requestId);
		// salesDto에 값을 넣어서 전달... 돌려막기....
		int maxId = outboundDao.selectMaxId();
		//
		outboundDao.insertOutbound(salesDto, maxId + 1, warehouseId);
		outboundDao.updateState(requestId);
	}

	// 넘어오는 값은 itemId, quantity 두가지이다
	public void shippingAction(Map<String, Object> jsonShippingVar) {
		List itemIdArr = (List) jsonShippingVar.get("itemId");
		List quantityArr = (List) jsonShippingVar.get("quantity");
		int requestId = (int) jsonShippingVar.get("requestId");
		System.out.println(itemIdArr.getClass().getSimpleName() + " " + itemIdArr);
		System.out.println(quantityArr.getClass().getSimpleName() + " " + quantityArr);
		System.out.println("requetId : " + requestId);

		int itemId;
		int quantity;
		V_stock_detailDto stockDto;
		for (int i = 0; i < itemIdArr.size(); i++) {
			itemId = Integer.parseInt((String) itemIdArr.get(i));
			quantity = Integer.parseInt((String) quantityArr.get(i));
			stockDto = stockDao.selectOldestStock(itemId);

			do {
				int stockQuantity = stockDto.getCount();
				if (stockQuantity > quantity) { // 재고가 더 많은 경우
					stockQuantity = stockQuantity - quantity;
					quantity = 0;
					Map<String, Integer> paramMap = new HashMap<>();
					paramMap.put("stockId", stockDto.getId());
					paramMap.put("quantity", stockQuantity);
					stockDao.updateStockQuantity(paramMap);
				} else if (stockQuantity == quantity) {
					stockDao.deleteStock(stockDto.getId());
					quantity = 0;
//			} else if(stockQuantity < quantity) {
				} else { // 출고품목이 더 많은 경우
					quantity = quantity - stockQuantity;
					stockDao.deleteStock(stockDto.getId());
				}
			} while (quantity != 0);
		}
		outboundDao.updateShippedDate(requestId);

	}

}
