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

import com.kosmo88.logistics_erp.wms.dao.ReceivingDao;
import com.kosmo88.logistics_erp.wms.dto.InboundDto;
import com.kosmo88.logistics_erp.wms.dto.ReceivingDto;
import com.kosmo88.logistics_erp.wms.service.ReceivingService;

@Controller
@RequestMapping("/wms/receiving")
public class ReceivingController {
	@Autowired
	ReceivingService receivingService;
	
	@Autowired
	ReceivingDao receivingDao;

	@RequestMapping(value = {"/receiving", "/"})
	public String receiving(HttpServletRequest req, Model model) {
		int warehouseId = Integer.parseInt(req.getParameter("id"));
		List<InboundDto> inboundDtoList = receivingDao.inboundList(warehouseId);
		model.addAttribute("inboundDtoList", inboundDtoList);
		return "wms/receiving/receiving";
	}

	@RequestMapping(value="/submitReceiving")
	public String submitReceiving() {
		return "";
	}
	
	@RequestMapping(value = {"/history"})
	public String ReceivingHistory() {
		return "wms/receiving/receivingStatus";
	}
	@RequestMapping("/detail")
	public String ReceivingDetail() {
		return "wms/receiving/receivingDetail";
	}
	
	
	
}

@RestController
@RequestMapping("/wms/receiving")
class ReceivingRestController{
	@Autowired
	ReceivingService receivingService;
	
	@ResponseBody
	@RequestMapping(value = {"/statusList"})
	public ArrayList<ReceivingDto> ReceivingStatus() {
		return receivingService.receivingList();
	}
	
	
}
