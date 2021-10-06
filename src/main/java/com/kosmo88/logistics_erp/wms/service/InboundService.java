package com.kosmo88.logistics_erp.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_InboundDto;

@Service
public class InboundService {

	@Autowired
	InboundDao inboundDao;
		
	public List<V_InboundDto> manageInbound(){
		return inboundDao.selectList();
	}


}
