package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import com.kosmo88.logistics_erp.wms.dto.RackDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;

public interface WarehouseDao {

	void insert(WarehouseDto warehouseDto);
	void insertRack(RackDto rackDto);
	List<WarehouseDto> select();
	int selectMaxId();
	void selectRack();
	WarehouseDto selectOne();
	void update(WarehouseDto warehouseDto); 
	void delete(); 
}
