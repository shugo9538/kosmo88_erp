package com.kosmo88.logistics_erp.controller.wms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logistics/dispatching")
public class DispatchingController {

	
	@RequestMapping(value = {"/dispatchingList", "/"})
	public String dispatchingList() {
		return "/logistics/dispatching/dispatchingList";
	}

	@RequestMapping("/addDispatching")
	public String addDispatching() {
		return "/logistics/dispatching/addDispatching";
	}
	@RequestMapping("/dispatchingDetail")
	public String dispatchingDetail() {
		return "/logistics/dispatching/dispatchingDetail";
	}
	@RequestMapping("/deleteDispatching")
	public String deleteDispatching(){
		return "/logistics/dispatching/deleteDispatching";
	}
}
