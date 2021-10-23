package com.kosmo88.logistics_erp.wms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo88.logistics_erp.util.FCMUtil;

@Controller
@RequestMapping("/test")
public class YrTestController {

	public YrTestController() {
	}

	@RequestMapping("/yrTest")
	public String testPage() {
		return "wms/testPage";
	}
	@RequestMapping("/yrTest2")
	public String testPage2() {
		return "wms/testPage2";
	}
	
	@ResponseBody
	@RequestMapping("/fcmTest")
	public void fcmtest(HttpServletRequest req) {
		FCMUtil.sendFcm("ㅊ ㅣ 훈님 뭐하세용", req.getServletContext().getRealPath("/WEB-INF/classes/fcm/fcmToken.json"));
	}

}
