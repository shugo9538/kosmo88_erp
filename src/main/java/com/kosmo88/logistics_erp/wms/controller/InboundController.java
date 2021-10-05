package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.purchase.dto.PurchaseRequestDTO;
import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_detailDto;
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
		List<V_purchaseDto> inboundDtoList = inboundService.manageInbound();
		model.addAttribute("inboundDtoList", inboundDtoList);
		return "wms/inbound/manageInbound";
	}

	@RequestMapping("/dispatch")
	public String dispatchInbound(Model model) {
//		List<V_warehouseDto> list = warehouseService.list();
		List<V_warehouse_simpleDto> list = warehouseService.simpleList();
		model.addAttribute("warehouseDtoList", list);
		return "wms/inbound/dispatchInbound";
	}
}

@RestController
class InboundRestControllser {

	@Autowired
	InboundService inboundService;
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	InboundDao inboundDao;

	// 입하 지시
	// 지정된 창고의 입하(입고)요청목록으로 보냄
	// TX_PURCHASE를 TX_INBOUND로 변환
	@RequestMapping("/dispatchAction")
	public void dispatchAction(HttpServletRequest req) {
		int requestId = Integer.parseInt(req.getParameter("request_id"));
		int warehouseId = Integer.parseInt(req.getParameter("warehouse_id"));
		System.out.println("warehouseId : " + warehouseId + " inboundId : " + requestId);
//		V_purchaseDto purchaseDto = inboundDao.selectOne(requestId);
		V_purchaseDto purchaseDto = inboundDao.selectOne(requestId);
//		inboundService.dispatchAction(inboundId, warehouseId);
		//구매 정보를 토대로 입하 정보 작성	
		inboundService.dispatchAction(purchaseDto, warehouseId);

	}

}