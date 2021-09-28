package com.kosmo88.logistics_erp.wms.dao;

import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;

public interface WarehouseDao {

	void insert(WarehouseDto warehouseDto);
	void select();
	int selectMaxId();
	void selectRack();
	void update(WarehouseDto warehouseDto); 
	void delete(); 
}
