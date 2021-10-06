package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.dto.V_Stock_SectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_datailDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.service.SectionService;
import com.kosmo88.logistics_erp.wms.service.StockService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;
import com.kosmo88.logistics_erp.wms.util.MyLog;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/wms/warehouse")
public class WarehouseController {

	
	@Autowired
	StockService stockService;
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	SectionService sectionService;
	
	
	
	@RequestMapping(value = "/add")
	public String add() {
		return "wms/warehouse/addWarehouse";
	}

	// 일단 첫 페이지 진입시에 warehouse하나의 페이지에 모든 페이지를 포함해서 한번에 보내고 Tab으로 설정할 계획이지만
	// 추후에 ajax로 바꿀 여지가 있다
	@RequestMapping(value = { "/warehouse", "/" })
	public String warehouse(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
		// 재고 정보
		List<V_Stock_SectionDto> stock_sectionDtoList = stockService.list(warehouseId);

		// 창고 정보
		WarehouseDto warehouseDto = warehouseService.warehouse(warehouseId);

//		List<SectionDto> sectionDtoList = sectionService.list(warehouseId);

		// 일단 객체 통째로 넣어보기
		model.addAttribute("warehouseDto", warehouseDto);
		model.addAttribute("stock_sectionDtoList", stock_sectionDtoList);
//		model.addAttribute("sectionDtoList", sectionDtoList);
		return "wms/warehouse/warehouse";
	}

	@RequestMapping(value = {"/", "/manage", "/list"})
	public String list(Model model) {
		List<V_warehouse_datailDto> list = warehouseService.list();
		model.addAttribute("warehouseDtoList", list);
		return "wms/warehouse/manageWarehouse";
	}

	@RequestMapping(value = "/addAction")
	public String addAction(HttpServletRequest req, Model model) {
		Map<String, String[]> paramMap = req.getParameterMap();
		MyLog.logParamMap(paramMap);
		int warehouseId = warehouseService.addAction(paramMap);
		sectionService.addAction(paramMap, warehouseId);

		return "wms/warehouse/warehouseList";
	}

	@RequestMapping("/modify")
	public String modify(Model model) {
		warehouseService.modify();
		return "wms/warehouse/modifyWarehouse";
	}

	@RequestMapping("/delete")
	public String delete(Model model) {
		warehouseService.delete();
		return "wms/warehouse/warehouseList";
	}

	@RequestMapping("/viewRack")
	public String viewRack(Model model) {
		warehouseService.viewRack();
		return "wms/warehouse/rackDetail";
	}

//    @RequestMapping("/rack")
//    public String rack(){
//    	return "";
//    }

}

//아마 객체정보를 response의 body message에 추가하는 메소드가 자동으로 생성되겠지? 
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/wms/warehouse")
class WarehouseRestController {
	@Autowired
	WarehouseService warehouseService;

	// 거래처(구매처) 목록
	@ResponseBody
	@RequestMapping(value = "/info")
	public List<V_warehouse_datailDto> warehouseList() {
		return warehouseService.list();
	}

}