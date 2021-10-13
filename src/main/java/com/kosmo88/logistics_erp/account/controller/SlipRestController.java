package com.kosmo88.logistics_erp.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.account.dto.SlipDTO;
import com.kosmo88.logistics_erp.account.service.SlipService;



//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@RestController
@RequestMapping(value ="/account/slip")
public class SlipRestController {
	private static final Logger logger = LoggerFactory.getLogger(SlipRestController.class);
	
	@Autowired
	SlipService slipService;
	
    // 장부관리 - 일반전표 상세내역 
	@ResponseBody
    @RequestMapping(value="/slipInfo")
    public List<SlipDTO> detailInfo(HttpServletRequest request, HttpServletResponse response) {
    	logger.info("/slipInfo");
    	
    	return slipService.slipDetailInfo(request, response);
    } 
	
	@ResponseBody
    @RequestMapping(value = "/fcm")
    public String fcmtest(HttpServletRequest request, HttpServletRequest reponse) throws Exception{
    	logger.debug("========================== fcm ddd ==========================");
    	
    	String tokenId = "d9ZLQRsbSWuNhewbzkBs7j:APA91bE4g3pc6rxsj9uuMkQ-Nl-5LNrdkJWplQvKzvAQhvCoPNme6FYKO9Yre2aFsc2aL2PGSA_0m5OAdpJCZGZT69angZNczVqauVorLKICm9rB2BWzqKHZ3_snAOaI4v7i0ub-9jPJ";
    	String title = "KU ERP Kosmo Ultimate ERP"; 
    	String content = "발주서 승인 되었습니다.";
    	
    	//FcmUtil fcm = new FcmUtil();
    	//fcm.send_FCM(tokenId, title, content);
    	
    	
    	return "account/slipSendAction";
    }
	
	
}
