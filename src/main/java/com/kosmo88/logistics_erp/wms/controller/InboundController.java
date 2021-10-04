package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosmo88.logistics_erp.wms.dto.V_InboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.service.InboundService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;

@Controller
@RequestMapping("/wms/inbound")
public class InboundController {

	@Autowired
	InboundService inboundService;
	@Autowired
	WarehouseService warehouseService;
	

	//관리자
	@RequestMapping("/manageInbound")
	public String manageInbound(Model model){
		List<V_InboundDto> inboundDtoList = inboundService.manageInbound();
		model.addAttribute("inboundDtoList",inboundDtoList);
		return "wms/inbound/manageInbound";
	}

	@RequestMapping("/dispatch")
	public String dispatchInbound(Model model){
//		List<V_warehouseDto> list = warehouseService.list();
		return "wms/inbound/dispatchInbound";
	}
}
