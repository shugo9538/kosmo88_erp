package com.kosmo88.logistics_erp.controller.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wms/transport")
public class TransportController {

	public TransportController() {
	}
//	@RequestMapping(value = {"/map", "/"})
	@RequestMapping("/map")
	public String ReceivingMap() {
		return "wms/transport/transportMap";
	}
	
	@RequestMapping(value = {"/list", "/"})
//	@RequestMapping("/list")
	public String ReceivingList() {
		return "wms/transport/transportList";
	}

	@RequestMapping("/detail")
	public String ReceivingDetail() {
		return "wms/transport/transportDetail";
	}
	
}
