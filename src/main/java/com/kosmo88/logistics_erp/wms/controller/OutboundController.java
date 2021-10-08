package com.kosmo88.logistics_erp.wms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dao.OutboundDao;
import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.V_inboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.service.OutboundService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;

@Controller
@RequestMapping("/wms/outbound")
public class OutboundController {

	@Autowired
	OutboundService outboundService;
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	OutboundDao outboundDao;
	@Autowired
	SectionDao sectionDao;

	public OutboundController() {
	}

	@RequestMapping(value = { "/shipping", "/" })
	public String ShippingList() {
		return "wms/outbound/shipping";
	}

	// 관리자
	@RequestMapping("/manageOutbound")
	public String manageInbound(Model model) {
		List<V_salesDto> salesDtoList = outboundService.manageOutbound();
		List<V_warehouseDto> list = warehouseService.warehouseList();
		List<V_outboundDto> outboundDtoList = outboundDao.allOutboundList();
		model.addAttribute("salesDtoList", salesDtoList);
		model.addAttribute("warehouseDtoList", list);
		model.addAttribute("outboundDtoList", outboundDtoList);
		return "wms/outbound/manageOutbound";
	}


}
	
	
@RestController

@RequestMapping("/wms/outbound")
class ShippingRestController{
	@Autowired
	OutboundService outboundService;
	
	@ResponseBody
	@RequestMapping(value = {"/statusList"})
	public ArrayList<V_outboundDto> ReceivingStatus() {
		return outboundService.shippingStatusList();
	}
	
	
}
