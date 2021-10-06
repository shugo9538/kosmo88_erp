package com.kosmo88.logistics_erp.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YrTestController {

	public YrTestController() {
	}

	@RequestMapping("/yrTest")
	public String testPage() {
		return "wms/testPage";
		
	}

}
