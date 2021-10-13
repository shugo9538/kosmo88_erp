package com.kosmo88.logistics_erp.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo88.logistics_erp.member.dto.LoginUserVO;
import com.kosmo88.logistics_erp.member.handler.AuthenticationHandler;
import com.kosmo88.logistics_erp.member.service.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
    @Autowired
    SqlSessionTemplate sqlSession;
    
	@RequestMapping(value = "/")
	public String home(Model model) {
	    logger.info("Welcome home! The client locale is {}.");
	    
	    return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
	    logger.info("current ===> login");
	    
	    return "member/login";
	}
	
	@RequestMapping(value = "/signIn")
	public String signIn(Model model) {
	    logger.info("current ===> login");
	    
	    return "member/signIn";
	}
	
	@RequestMapping(value = "/signInAction")
	public String signInAction(HttpServletRequest req, Model model) {
		logger.info("current ===> login");
		userService.signinAction(req, model);
		
		return "member/login";
	}
	
}
