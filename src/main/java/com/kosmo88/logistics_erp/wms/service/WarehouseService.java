package com.kosmo88.logistics_erp.wms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;

@Service
public class WarehouseService {
	@Autowired
	WarehouseDao warehouseDao;
	
	public void warehouse() {
	}
	
	//관리자 옵션
	public void add() {
	}

	//관리자 옵션
	public List<WarehouseDto> list() {
		List<WarehouseDto> list = warehouseDao.select();
		return list;

	}

	//랙 등록을 위해 창고번호 리턴하기
	public int addAction(Map<String, String[]> paramMap) {
		WarehouseDto warehouseDto = new WarehouseDto();
//     	얘도 나중에 Service에 집어넣자
		DtoFunction.setDtoFromParamMap(paramMap, warehouseDto);
		warehouseDto.setAddress(paramMap.get("basicAddr")[0] + paramMap.get("detailAddr")[0]);
		int maxId = warehouseDao.selectMaxId();
		warehouseDto.setId(maxId + 1);
		System.out.println("WarehouseDto 정보 : " + warehouseDto);
		warehouseDao.insert(warehouseDto);
		return maxId+1;//이걸 랙한테도 줘야돼
	}

	public void stock() {
	}

	public void modify() {
	}

	public void delete() {
	}

	

	public void viewRack() {
	}
}
