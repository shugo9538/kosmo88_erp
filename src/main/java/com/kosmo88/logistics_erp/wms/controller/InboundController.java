package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.util.FCMUtil;
import com.kosmo88.logistics_erp.wms.dao.InboundDao;
import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dto.V_inboundDto;
import com.kosmo88.logistics_erp.wms.dto.V_inbound_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_purchaseDto;
import com.kosmo88.logistics_erp.wms.dto.V_request_itemDto;
import com.kosmo88.logistics_erp.wms.dto.V_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.service.InboundService;
import com.kosmo88.logistics_erp.wms.service.SectionService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;
import com.kosmo88.logistics_erp.wms.util.MyLog;

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
	@Autowired 
	SectionService sectionService;

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
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		List<V_request_itemDto> purchaseItemDtoList = inboundService.productDtoList(requestId);
		List<V_warehouseDto> warehouseDtoist = warehouseService.warehouseList();
		model.addAttribute("purchaseItemDtoList", purchaseItemDtoList);
		model.addAttribute("warehouseDtoList", warehouseDtoist);
		//구매품목 개수
		int itemCount = purchaseItemDtoList.size();
		model.addAttribute("itemCount", itemCount);
		model.addAttribute("requestIdId", requestId);
		return "wms/inbound/dispatchInbound";
	}
	
	
	//입고
	@RequestMapping(value = { "/manageWarehousing", "/" })
	public String manageWarehousing(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
		List<V_inboundDto> inboundDtoList = inboundDao.selectDispatchedInboundList(warehouseId);
		model.addAttribute("inboundDtoList", inboundDtoList);

		//입고 완료목록
		List<V_inbound_itemDto> warehousedInboundItemDtoList = inboundDao.selectWarehousedInboundItemList(warehouseId);
		model.addAttribute("warehousedInboundDtoList", warehousedInboundItemDtoList);
		model.addAttribute("warehouseId", warehouseId);
		return "wms/inbound/manageWarehousing";
	}

	
	@RequestMapping(value = "/warehousing")
	public String warehousing(HttpServletRequest req, Model model) {
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));
		
		//요 아이템 리스트를 in절에 사용할 수 없을까?
		List<V_request_itemDto> itemDtoList = inboundDao.selectItemList(requestId);
		model.addAttribute("itemDtoList", itemDtoList);
		String[] itemArr= itemDtoList.stream().map(e->e.getItem_name()).toArray(String[]::new);
		int rowNum = itemDtoList.size();

		List<V_sectionDto> sectionDtolist = sectionService.validSectionList(warehouseId, rowNum, itemArr);
		model.addAttribute("sectionDtoList", sectionDtolist);
		return "wms/inbound/warehousing";
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
		MyLog.logReqParamMap(req.getParameterMap());
		
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));
		int requestId = Integer.parseInt(req.getParameter("requestId"));
		System.out.println("warehouseId : " + warehouseId + " inboundId : " + requestId);
		inboundService.dispatchAction(warehouseId, requestId);
		String fcmMessage = requestId + "번 요청의 입하를 지시하였습니다";
		FCMUtil.sendFcm(fcmMessage, req.getServletContext().getRealPath("/WEB-INF/classes/fcm/fcmToken_ych.json"));

	}
	
	
	

	//물품이 입고되면 대기목록에서 안보여야한다 (warehoused_date값 주기)
	//stock 등록()
	//보내야 할 정보 : warehouseId, 

//	@RequestMapping("/warehousingAction")
//	public void warehousingAction(HttpServletRequest req) {
//		Map<String, String[]> paramMap = req.getParameterMap(); 
//		MyLog.logReqParamMap(paramMap);
//		int requestId = Integer.parseInt(req.getParameter("requestId"));
//		inboundService.warehousingAction(paramMap, requestId); 
//		System.out.println(paramMap.toString());
//
//		//상태코드 대신 inbound에 날짜 넣기
//		inboundDao.updateWarehousedDate(requestId);
//	}
	
	
	@RequestMapping("/warehousingAction")
	public void warehousingAction(HttpServletRequest req, @RequestBody Map<String, Object> jsonWarehousingVar) {
		jsonWarehousingVar.entrySet().stream().forEach(e->System.out.println(e.getKey() +" "+e.getValue()));

		inboundService.warehousingAction(jsonWarehousingVar);
		int requestId = 0;
		try {
		requestId = (int) jsonWarehousingVar.get("requestId");
		} catch (Exception e ) {
			e.getStackTrace();
		}
		String fcmMessage = requestId + "번 요청의 출고가 완료되었습니다";
		FCMUtil.sendFcm(fcmMessage, req.getServletContext().getRealPath("/WEB-INF/classes/fcm/fcmToken_ych.json"));

	}


}