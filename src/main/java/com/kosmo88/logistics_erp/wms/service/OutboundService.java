package com.kosmo88.logistics_erp.wms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.wms.dao.OutboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;

@Service
public class OutboundService {
	
	@Autowired
	OutboundDao outboundDao;

	public ArrayList<V_outboundDto> shippingStatusList() {
		return (ArrayList<V_outboundDto>) outboundDao.select();
	}

	public List<V_salesDto> manageOutbound() {
		return null;
	}

}
