package com.kosmo88.logistics_erp.controller.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wms/shipping")
public class ShippingController {

	public ShippingController() {
	}
	
	@RequestMapping(value = {"/list", "/"})
	public String ShippingList() {
		return "wms/shipping/shippingList";
	}

	@RequestMapping("/view")
	public String ShippingDetail() {
		return "wms/shipping/shippingDetail";
	}
}
