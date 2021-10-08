package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.V_inboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchase_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_section_detailDto;
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
	@Autowired
	InboundDao inboundDao;
	@Autowired
	SectionDao sectionDao;

	// 관리자
	@RequestMapping("/manageInbound")
	public String manageInbound(Model model) {
		List<V_purchaseDto> purchaseDtoList = inboundService.manageInbound();
		List<V_warehouseDto> list = warehouseService.warehouseList();
		List<V_inboundDto> inboundDtoList = inboundDao.allInboundList();
		model.addAttribute("purchaseDtoList", purchaseDtoList);
		model.addAttribute("warehouseDtoList", list);
		model.addAttribute("inboundDtoList", inboundDtoList);
		return "wms/inbound/manageInbound";
	}

	@RequestMapping("/dispatch")
	public String dispatchInbound(HttpServletRequest req, Model model) {
//		List<V_warehouseDto> list = warehouseService.list();
		int purchaseId = Integer.parseInt(req.getParameter("purchaseId"));
		List<V_purchase_itemDto> purchaseItemDtoList = inboundService.productDtoList(purchaseId);
		List<V_warehouseDto> warehouseDtoist = warehouseService.warehouseList();
		model.addAttribute("purchaseItemDtoList", purchaseItemDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoist);
		//구매품목 개수
		int itemCount = purchaseItemDtoList.size();
		model.addAttribute("ItemCount", itemCount);
		model.addAttribute("purchaseId", purchaseId);
		return "wms/inbound/dispatchInbound";
	}
	
	
	//입고
	@RequestMapping(value = { "/warehousing", "/" })
	public String warehousing(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
		List<V_inboundDto> inboundDtoList = inboundDao.dispatchedInboundList(warehouseId);
		model.addAttribute("inboundDtoList", inboundDtoList);
		model.addAttribute("warehouseId", warehouseId);
		return "wms/inbound/warehousing";
	}

	@RequestMapping(value = "/approve")
	public String approve(HttpServletRequest req, Model model) {
		int inboundId = Integer.parseInt(req.getParameter("inboundId"));
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));
		List<V_purchase_itemDto> itemDtoList = inboundService.productDtoList(inboundId);

//	List<V_warehouse_sectionDto> sectionDtolist = sectionDao.sectionList(warehouseId);
	List<V_sectionDto> sectionDtolist = sectionDao.sectionList(warehouseId);
		model.addAttribute("itemDtoList", itemDtoList);
		model.addAttribute("sectionDtoList", sectionDtolist);
		return "wms/inbound/approve";
	}

	
	
	
	
}

@RestController
@RequestMapping("/wms/inbound")
class InboundRestController {

	@Autowired
	InboundService inboundService;
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	InboundDao inboundDao;

	// 입하 지시
	//ajax 아직
	@RequestMapping("/dispatchAction")
	public void dispatchAction(HttpServletRequest req) {
		int warehouseId = Integer.parseInt(req.getParameter("warehouse_id"));
		int purchaseId = Integer.parseInt(req.getParameter("purchase_id"));
		System.out.println("warehouseId : " + warehouseId + " inboundId : " + purchaseId);
		inboundService.dispatchAction(warehouseId, purchaseId);
	}

}