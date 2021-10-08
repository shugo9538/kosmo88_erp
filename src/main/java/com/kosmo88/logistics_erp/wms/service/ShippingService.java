package com.kosmo88.logistics_erp.wms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.ShippingDao;
import com.kosmo88.logistics_erp.wms.dto.ShippingDto;

@Service
public class ShippingService {
	
	@Autowired
	ShippingDao shippingDao;

	public ArrayList<ShippingDto> shippingStatusList() {
		return (ArrayList<ShippingDto>) shippingDao.select();
	}

}
