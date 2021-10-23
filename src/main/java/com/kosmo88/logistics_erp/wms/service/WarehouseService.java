package com.kosmo88.logistics_erp.wms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.SectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_detailDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class WarehouseService {
	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	SectionDao sectionDao;

	public WarehouseDto warehouse(int id) {
		return warehouseDao.selectOne(id);
	}

	// 관리자 옵션
	public void add() {
	}

	// 관리자 옵션
	public List<V_warehouseDto> warehouseList() {
		List<V_warehouseDto> warehouseList = warehouseDao.selectWarehouseList();
//		MyLog.logList(warehouseList);
		return warehouseList;
	}

	public List<V_warehouse_detailDto> detailList() {
		List<V_warehouse_detailDto> detailList = warehouseDao.selectDetailList();
		MyLog.logList(detailList);
		return detailList;

	}

	public void addAction(Map<String, String[]> paramMap) {
		WarehouseDto warehouseDto = new WarehouseDto();
		DtoFunction.setDtoFromParamMap(paramMap, warehouseDto);
		warehouseDto.setAddress(paramMap.get("basicAddr")[0] + paramMap.get("detailAddr")[0]);
		int maxId = warehouseDao.selectMaxId();
		warehouseDto.setId(maxId + 1);
		System.out.println("WarehouseDto 정보 : " + warehouseDto);
		warehouseDao.insert(warehouseDto);

		int warehouseId = maxId + 1;

		// 섹션 등록
		int additionalFormCnt = Integer.parseInt(paramMap.get("additionalFormCnt")[0]);
		System.out.println("additionalFromCnt : " + additionalFormCnt);
		List<SectionDto> dtoList = (List<SectionDto>) DtoFunction.getDtoListFromParamMap(paramMap, SectionDto.class,
				additionalFormCnt);
		for (SectionDto sectionDto : dtoList) {
			sectionDto.setWarehouse_id(warehouseId);
			sectionDao.insert(sectionDto);
		}
	}

	public List<V_warehouse_sectionDto> sectionList(int warehouseId) {
		return warehouseDao.sectionList(warehouseId);
	}

	public void addSection(Map<String, String[]> paramMap, int warehouseId) {

		int additionalFormCnt = Integer.parseInt(paramMap.get("additionalFormCnt")[0]);
		System.out.println("additionalFromCnt : " + additionalFormCnt);
		Set<SectionDto> dtoSet = (Set<SectionDto>) DtoFunction.getDtoSetFromParamMap(paramMap, SectionDto.class,
				additionalFormCnt);
		for (SectionDto sectionDto : dtoSet) {
			sectionDto.setWarehouse_id(warehouseId);
			sectionDao.insert(sectionDto);
		}
	}
}
