package com.kosmo88.logistics_erp.wms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
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

	

	// 관리자
	@RequestMapping("/manageOutbound")
	public String manageInbound(Model model) {
		List<V_salesDto> salesDtoList = outboundDao.selectSalesList();
		List<V_warehouseDto> warehouseDtoList = warehouseService.warehouseList();
		List<V_outboundDto> outboundDtoList = outboundDao.allOutboundList();
		model.addAttribute("salesDtoList", salesDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoList);
		model.addAttribute("outboundDtoList", outboundDtoList);
		
		//출하 내역
		
		return "wms/outbound/manageOutbound";
	}


	@RequestMapping(value = { "/manageShipping", "/" })
	public String ShippingList(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
//		List<V_outboundDto> outboundDtoList = outboundDao.selectDispatchedOutboundList(warehouseId);
//		List<V_outboundDto> shippedOutboundDtoList = outboundDao.selectShippedOutboundList(warehouseId);
//		model.addAttribute("outboundDtoList", outboundDtoList);
//		model.addAttribute("shippedOutboundDtoList", shippedOutboundDtoList);
//		model.addAttribute("warehouseId", warehouseId);
		return "wms/outbound/manageShipping";
	}
	
	
	@RequestMapping("/dispatch")
	public String dispatchOutbound(HttpServletRequest req, Model model) {
//		List<V_warehouseDto> list = warehouseService.list();
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		List<V_request_itemDto> salesItemDtoList = outboundDao.selectItemList(requestId);
		List<V_warehouseDto> warehouseDtoist = warehouseService.warehouseList();
		model.addAttribute("salesItemDtoList", salesItemDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoist);
		//구매품목 개수
		int itemCount = salesItemDtoList.size();
		model.addAttribute("itemCount", itemCount);
		model.addAttribute("requestId", requestId);
		return "wms/outbound/dispatchOutbound";
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
	

	@RequestMapping("/dispatchAction")
	public void dispatchAction(HttpServletRequest req) {
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		System.out.println("warehouseId : " + warehouseId + " outboundId : " + requestId);
		outboundService.dispatchAction(warehouseId, requestId);
	}
}
