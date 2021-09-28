package com.kosmo88.logistics_erp.wms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;

@Service
public class WarehouseService {
	@Autowired
	WarehouseDao warehouseDao;

	public void add() {
	}

	public void list() {

	}

	public void addAction(WarehouseDto warehouseDto) {
		int maxId = warehouseDao.selectMaxId();
		warehouseDto.setId(maxId+1);
		warehouseDao.insert(warehouseDto);
	}

	public void stock() {
	}

	public void modify() {
	}

	public void delete() {
	}

	public void view() {
	}

	public void viewRack() {
	}
}
