package com.kosmo88.logistics_erp.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wms/receiving")
public class ReceivingController {

	public ReceivingController() {
	}
	
	@RequestMapping(value = {"/list", "/"})
	public String ReceivingList() {
		return "wms/receiving/receivingList";
	}

	@RequestMapping("/detail")
	public String ReceivingDetail() {
		return "wms/receiving/receivingDetail";
	}
}
