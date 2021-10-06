package com.kosmo88.logistics_erp.wms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.SectionDto;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class SectionService {

	@Autowired
	SectionDao sectionDao;

	public void list() {

	}

	public List<SectionDto> list(int warehouseId) {
		List<SectionDto> sectionList = sectionDao.selectList(warehouseId); 
		MyLog.logList(sectionList);
		return sectionList;
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
		Set<SectionDto> dtoSet = (Set<SectionDto>) DtoFunction.getDtoSetFromParamMap(paramMap, SectionDto.class, additionalFormCnt);
		for(SectionDto sectionDto : dtoSet) {
			int maxSectionId = sectionDao.selectMaxId();
			sectionDto.setId(maxSectionId+1);
			sectionDto.setWarehouse_id(warehouseId);
			System.out.println("SectionDto 정보 : " + sectionDto);
			sectionDao.insert(sectionDto);
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

	public void viewSection() {
	}

}
