package com.kosmo88.logistics_erp.controller.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wms/receiving")
public class ReceivingController {

	public ReceivingController() {
	}
	
	@RequestMapping(value = {"/receivingList.do", "/"})
	public String ReceivingList() {
		return "wms/receiving/receivingList";
	}

	@RequestMapping("/receivingDetail.do")
	public String ReceivingDetail() {
		return "wms/receiving/receivingDetail";
	}
}
