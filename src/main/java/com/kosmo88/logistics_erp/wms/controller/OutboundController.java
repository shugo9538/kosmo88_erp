package com.kosmo88.logistics_erp.wms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dao.OutboundDao;
import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.V_outboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_outbound_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_salesDto;
import com.kosmo88.logistics_erp.wms.dto.V_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.service.OutboundService;
import com.kosmo88.logistics_erp.wms.service.SectionService;
import com.kosmo88.logistics_erp.wms.service.StockService;
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
	SectionService sectionService;
	@Autowired
	SectionDao sectionDao;
	@Autowired
	StockService stockService;
	

	// 관리자
	@RequestMapping("/manageOutbound")
	public String manageInbound(Model model) {
		List<V_salesDto> salesDtoList = outboundDao.selectSalesList();
		List<V_warehouseDto> warehouseDtoList = warehouseService.warehouseList();
		List<V_outboundDto> outboundDtoList = outboundDao.allOutboundList();
		model.addAttribute("salesDtoList", salesDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoList);
		model.addAttribute("outboundDtoList", outboundDtoList);

		// 출하 내역
		return "wms/outbound/manageOutbound";
	}
	
	
	@RequestMapping("/dispatch")
	public String dispatchOutbound(HttpServletRequest req, Model model) {
//		List<V_warehouseDto> list = warehouseService.list();
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		List<V_request_itemDto> salesItemDtoList = outboundDao.selectItemList(requestId);
		List<V_warehouseDto> warehouseDtoist = warehouseService.warehouseList();
		model.addAttribute("salesItemDtoList", salesItemDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoist);
		// 구매품목 개수
		int itemCount = salesItemDtoList.size();
		model.addAttribute("itemCount", itemCount);
		model.addAttribute("requestId", requestId);
		return "wms/outbound/dispatchOutbound";
	}

	
	@RequestMapping(value = { "/manageShipping", "/" })
	public String ShippingList(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
		List<V_outboundDto> outboundDtoList = outboundDao.selectDispatchedOutboundList(warehouseId);
		model.addAttribute("outboundDtoList", outboundDtoList);

		//완료목록
		List<V_outbound_itemDto> shippedOutboundDtoList = outboundDao.selectShippedOutboundList(warehouseId);
		model.addAttribute("shippedOutboundDtoList", shippedOutboundDtoList);
		model.addAttribute("warehouseId", warehouseId);
		return "wms/outbound/manageShipping";
	}


	@RequestMapping("/shipping")
	public String shipping(HttpServletRequest req, Model model) {
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));

		// 요 아이템 리스트를 in절에 사용할 수 없을까?
		List<V_request_itemDto> itemDtoList = outboundDao.selectItemList(requestId);
		model.addAttribute("itemDtoList", itemDtoList);
		String[] itemArr = itemDtoList.stream().map(e -> e.getItem_name()).toArray(String[]::new);
		int rowNum = itemDtoList.size();

		// 아이템 목록을 받아와서 재고 정보에서 검색
		// 일단 여기서는 다 가져오고, 승인시 다 날짜별로 뺀다
		List<V_stockDto> stockDtolist = stockService.validStockList(warehouseId, rowNum, itemArr);
		model.addAttribute("stockDtoList", stockDtolist);

		return "wms/outbound/shipping";
	}

}

@RestController
@RequestMapping("/wms/outbound")
class ShippingRestController {
	@Autowired
	OutboundService outboundService;

	@RequestMapping(value = { "/statusList" })
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

	// 해야할것 1. 재고 가져오기 2. 재고 날짜 확인 3. 날짜별로 갯수 확인하면서 갯수 맞추기
	@RequestMapping("/shippingAction")
	public void shippingAction(@RequestBody Map<String, Object> jsonShippingVar) {
		jsonShippingVar.entrySet().stream().forEach(e->System.out.println(e.getKey() +" "+e.getValue()));

		outboundService.shippingAction(jsonShippingVar);
	}

}
