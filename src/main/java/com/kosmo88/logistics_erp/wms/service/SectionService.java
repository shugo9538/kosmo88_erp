package com.kosmo88.logistics_erp.wms.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.V_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_section_detailDto;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class SectionService {

	@Autowired
	SectionDao sectionDao;

	public void list() {

	}

	public List<V_sectionDto> sectionList(int warehouseId) {
//		List<V_section_detailDto> sectionList = sectionDao.selectList(warehouseId); 
		List<V_sectionDto> sectionList = sectionDao.sectionList(warehouseId); 
		MyLog.logList(sectionList);
		return sectionList;
	}
	
	
	public List<V_sectionDto> validSectionList(int warehouseId, int rowNum, String[] itemArr){
//	public List<V_sectionDto> validSectionList(int warehouseId, int rowNum, List itemIdList){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("warehouseId", warehouseId);
		paramMap.put("rowNum", rowNum);
//		paramMap.put("itemIdArr", itemIdArr);
		paramMap.put("itemArr", itemArr);

//		paramMap.put("itemIdArr", Arrays.toString(itemIdArr).replace('[', '(').replace(']', ')'));

		return sectionDao.selectValidSectionList(paramMap);

	}

	public void add() {
	}

	public void addAction() {
	}


	public void addAction(Map<String, String[]> paramMap, int warehouseId) {

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
