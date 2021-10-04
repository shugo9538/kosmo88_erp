package com.kosmo88.logistics_erp.wms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.ReceivingDao;
import com.kosmo88.logistics_erp.wms.dto.ReceivingDto;

@Service
public class ReceivingService {
	
	@Autowired
	ReceivingDao receivingDao;

	public ArrayList<ReceivingDto> receivingList() {
		return (ArrayList<ReceivingDto>) receivingDao.select();
	}

}
