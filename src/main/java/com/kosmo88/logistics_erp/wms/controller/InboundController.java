package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchase_productDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_simpleDto;
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

	// 관리자
	@RequestMapping("/manageInbound")
	public String manageInbound(Model model) {
		List<V_purchaseDto> purchaseDtoList = inboundService.manageInbound();
		model.addAttribute("purchaseDtoList", purchaseDtoList);
		return "wms/inbound/manageInbound";
	}

	@RequestMapping("/dispatch")
	public String dispatchInbound(HttpServletRequest req, Model model) {
//		List<V_warehouseDto> list = warehouseService.list();
		int purchase_id = Integer.parseInt(req.getParameter("purchase_id"));
		List<V_purchase_productDto> productDtoList = inboundService.productDtoList(purchase_id);
		List<V_warehouse_simpleDto> list = warehouseService.simpleList();
		model.addAttribute("productDtoList", productDtoList);
		model.addAttribute("warehouseDtoList", list);
		return "wms/inbound/dispatchInbound";
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

	@RequestMapping("/dispatchAction")
	public void dispatchAction(HttpServletRequest req) {
		int warehouseId = Integer.parseInt(req.getParameter("warehouse_id"));
		int purchaseId = Integer.parseInt(req.getParameter("purchase_id"));
		System.out.println("warehouseId : " + warehouseId + " inboundId : " + purchaseId);
		inboundService.dispatchAction(warehouseId, purchaseId);

	}

}