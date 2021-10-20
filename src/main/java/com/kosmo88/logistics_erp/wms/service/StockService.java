package com.kosmo88.logistics_erp.wms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dto.V_section_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_stockDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class StockService {

	@Autowired
	StockDao stockDao;

	public List<V_section_stockDto> list(int warehouseId) {
//		List<StockDto> stockList = stockDao.selectList(warehouseId); 
		List<V_section_stockDto> stock_sectionDtoList = stockDao.selectStockDetailList(warehouseId); 
		MyLog.logList(stock_sectionDtoList);
		return stock_sectionDtoList;
	}

	public List<V_stockDto> validStockList(int warehouseId, int rowNum, String[] itemArr){
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("warehouseId", warehouseId);
			paramMap.put("rowNum", rowNum);
			paramMap.put("itemArr", itemArr);


			return stockDao.selectValidStockList(paramMap);
	}
}
