package com.kosmo88.logistics_erp.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_section_stockDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class StockService {

	@Autowired
	StockDao stockDao;

	public List<V_section_stockDto> list(int warehouseId) {
//		List<StockDto> stockList = stockDao.selectList(warehouseId); 
		List<V_section_stockDto> stock_sectionDtoList = stockDao.sectionStockList(warehouseId); 
		MyLog.logList(stock_sectionDtoList);
		return stock_sectionDtoList;
	}

}
