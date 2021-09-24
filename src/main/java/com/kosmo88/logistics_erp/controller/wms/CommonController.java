package com.kosmo88.logistics_erp.controller.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wms/common")
public class CommonController {

	@RequestMapping("/addressForm")
	public String addressForm(){
		return "wms/common/addressForm";
	}
	
	@RequestMapping("/jusoPopup")
	public String jusoPopup() {
		return "wms/common/jusoPopup";
		
	}
}
