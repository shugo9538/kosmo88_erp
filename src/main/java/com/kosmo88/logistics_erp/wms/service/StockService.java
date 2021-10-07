package com.kosmo88.logistics_erp.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dto.StockDto;
import com.kosmo88.logistics_erp.wms.dto.V_Stock_SectionDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class StockService {

	@Autowired
	StockDao stockDao;

	public List<V_Stock_SectionDto> list(int warehouseId) {
//		List<StockDto> stockList = stockDao.selectList(warehouseId); 
		List<V_Stock_SectionDto> stock_sectionDtoList = stockDao.selectList(warehouseId); 
		MyLog.logList(stock_sectionDtoList);
		return stock_sectionDtoList;
	}

}
