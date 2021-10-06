package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import com.kosmo88.logistics_erp.wms.dto.ShippingDto;

public interface ShippingDao {
	void insert();
	List<ShippingDto> select();
	void selectRack();
	void update(); 
	void delete(); 
}
