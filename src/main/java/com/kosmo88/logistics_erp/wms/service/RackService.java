package com.kosmo88.logistics_erp.wms.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddInitTransformer;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.RackDao;
import com.kosmo88.logistics_erp.wms.dto.RackDto;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;

@Service
public class RackService {

	@Autowired
	RackDao rackDao;

	public void list() {

	}

	public void add() {
	}

	public void addAction() {
	}

	// 랙의 경우 여러개의 폼을 가진다
	// 하나의 폼은 여러 개의 input으로 이루어져 있으며, 같은 index를 공유한다
	// 따라서 paramMap에서 인덱스 순으로 하나의 폼씩 가져와서
	// 하나의 row(Map)을 만들어서 하나씩 대입해야 한다
	public void addAction(Map<String, String[]> paramMap, int warehouseId) {
		int additionalFormCnt = Integer.parseInt(paramMap.get("additionalFormCnt")[0]);
		System.out.println("additionalFromCnt : " + additionalFormCnt);
		Set<RackDto> dtoset = DtoFunction.getDtoSetFromIndexedParamMap(paramMap, RackDto.class, additionalFormCnt);
		for (RackDto rackDto : dtoset) {
			int maxRackId = rackDao.selectMaxId();
			rackDto.setId(maxRackId+1);
			rackDto.setWarehouseId(warehouseId);
			System.out.println("RackDto 정보 : " + rackDto);
			rackDao.insert(rackDto);
		}

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
