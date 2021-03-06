package com.kosmo88.logistics_erp.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.dao.SectionDao;
import com.kosmo88.logistics_erp.wms.dao.StockDao;
import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.V_sectionDto;
import com.kosmo88.logistics_erp.wms.dto.V_stockDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouseDto;
import com.kosmo88.logistics_erp.wms.dto.V_warehouse_detailDto;
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
	WarehouseDao warehouseDao;
	SectionService sectionService;
	@Autowired
	SectionDao sectionDao;
	@Autowired
	StockDao stockDao;


	// 일단 첫 페이지 진입시에 warehouse하나의 페이지에 모든 페이지를 포함해서 한번에 보내고 Tab으로 설정할 계획이지만
	// 추후에 ajax로 바꿀 여지가 있다
	@RequestMapping(value = { "/warehouse", "/" })
	public String warehouse(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));

		V_warehouseDto warehouseDto = warehouseDao.selectWarehouse(warehouseId);
		model.addAttribute("warehouseDto", warehouseDto);

		// 섹션 정보
		List<V_sectionDto> sectionDtoList = sectionDao.sectionList(warehouseId);
		model.addAttribute("sectionDtoList", sectionDtoList);
//		List<V_section_detailDto> section_detailDtoList = sectionDao.sectionList(warehouseId);
//		model.addAttribute("section_detailDtoList", section_detailDtoList);

		// 재고 정보
		List<V_stockDto> stockDtoList = stockDao.selectStockList(warehouseId);
		model.addAttribute("stockDtoList", stockDtoList);

		return "wms/warehouse/warehouse";
	}

	// 보류
	@RequestMapping(value = { "/list", "/warehouseList" })
	public String warehouseList(Model model) {
		List<V_warehouseDto> list = warehouseDao.selectWarehouseList();

		model.addAttribute("warehouseDtoList", list);
		return "wms/warehouse/warehouseList";
	}


	@RequestMapping(value = "manage")
	public String manageWarehouse(HttpServletRequest req, Model model) {
		//=============
		int warehouseId = Integer.parseInt(req.getParameter("id"));

		V_warehouseDto warehouseDto = warehouseDao.selectWarehouse(warehouseId);
		model.addAttribute("warehouseDto", warehouseDto);

		// 섹션 정보
		List<V_sectionDto> sectionDtoList = sectionDao.sectionList(warehouseId);
		model.addAttribute("sectionDtoList", sectionDtoList);

		// 재고 정보
//		List<V_stock_detailDto> stock_detailDtoList = stockDao.warehouseStockList(warehouseId);
//		model.addAttribute("stock_detailDtoList", stock_detailDtoList);
		model.addAttribute("warehouseId", warehouseId);
		model.addAttribute("lastSection", sectionDao.selectLastSection(warehouseId));

		return "wms/warehouse/manageWarehouse";
	}

	

	@RequestMapping(value = "/detailList")
	public String list(Model model) {
		List<V_warehouse_detailDto> list = warehouseService.detailList();
		model.addAttribute("warehouseDtoList", list);
		return "wms/warehouse/manageWarehouse";
	}

	@Transactional
	@RequestMapping(value = "/addAction")
	public String addAction(HttpServletRequest req, Model model) {
//	public void addAction(HttpServletRequest req, Model model) {
		Map<String, String[]> paramMap = req.getParameterMap();
		MyLog.logReqParamMap(paramMap);
		warehouseService.addAction(paramMap);

//		return "wms/warehouse/warehouseList";
		return "redirect:/wms/warehouse/list";
	}
	
	@RequestMapping(value = "/addSectionAction")
	public String addSectionAction(HttpServletRequest req, Model model) {
		Map<String, String[]> paramMap = req.getParameterMap();
		int warehouseId = Integer.parseInt(req.getParameter("warehouseId"));
//		MyLog.logParamMap(paramMap);
		warehouseService.addSection(paramMap, warehouseId);

		//list
		List<V_warehouseDto> list = warehouseDao.selectWarehouseList();
		model.addAttribute("warehouseDtoList", list);
		
		return "wms/warehouse/warehouseList";
	}


}

//아마 객체정보를 response의 body message에 추가하는 메소드가 자동으로 생성되겠지? 
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value = "/wms/warehouse")
class WarehouseRestController {
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	WarehouseDao warehouseDao;

	// 거래처(구매처) 목록
	@ResponseBody
	@RequestMapping(value = "/info")
	public List<V_warehouseDto> warehouseList() {
		return warehouseService.warehouseList();
	}
	
	//rest용.. 안드로이드에서 조회용으로 사용 
//	@RequestMapping(value = { "/list", "/warehouseList" })
//	public List<V_warehouseDto> warehouseList(Model model) {
//		List<V_warehouseDto> list = warehouseDao.selectWarehouseList();
//
//		return list;
//	}

}