package com.kosmo88.logistics_erp.wms.dao;

import com.kosmo88.logistics_erp.wms.dto.RackDto;

public interface RackDao {

	void insert(RackDto rackDto);
	void select();
//	int selectMaxId(RackDto rackDto);
	int selectMaxId();
	void selectRack();
	void update(); 
	void delete(); 
}
