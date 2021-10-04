package com.kosmo88.logistics_erp.wms.dao;

import java.util.List;

import com.kosmo88.logistics_erp.wms.dto.ReceivingDto;

public interface ReceivingDao {

	void insert();
	List<ReceivingDto> select();
}
