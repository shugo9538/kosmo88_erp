package com.kosmo88.logistics_erp.wms.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.SectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_Stock_SectionDto;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;
import com.kosmo88.logistics_erp.wms.util.MyLog;

@Service
public class SectionService {

	@Autowired
	SectionDao sectionDao;

	public void list() {

	}

	public List<V_Stock_SectionDto> list(int warehouseId) {
		List<V_Stock_SectionDto> sectionList = sectionDao.selectList(warehouseId); 
		MyLog.logList(sectionList);
		return sectionList;
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
