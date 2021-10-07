package com.kosmo88.logistics_erp.wms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosmo88.logistics_erp.wms.dto.ShippingDto;
import com.kosmo88.logistics_erp.wms.service.ShippingService;

@Controller
@RequestMapping("/wms/shipping")
public class ShippingController {
	
	@Autowired
	ShippingService shippingService;
	
	public ShippingController() {
	}
	
	@RequestMapping(value = {"/shipping", "/"})
	public String ShippingList() {
		return "wms/shipping/shipping";
	}

//	@RequestMapping("/view")
//	public String ShippingDetail() {
//		return "wms/shipping/shippingDetail";
//	}
}

@RestController

@RequestMapping("/wms/shipping")
class ShippingRestController{
	@Autowired
	ShippingService shippingService;
	
	@ResponseBody
	@RequestMapping(value = {"/statusList"})
	public ArrayList<ShippingDto> ReceivingStatus() {
		return shippingService.shippingStatusList();
	}
	
	
}
