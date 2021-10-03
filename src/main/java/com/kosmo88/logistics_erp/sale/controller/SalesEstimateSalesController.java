package com.kosmo88.logistics_erp.sale.controller;

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

import com.kosmo88.logistics_erp.sale.dto.SalesEstimateListViewDTO;
import com.kosmo88.logistics_erp.sale.service.SalesEstimateService;

@SessionAttributes({"session", "userid"})
@RestController
@RequestMapping
public class SalesEstimateSalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesEstimateSalesController.class);
	
	@Autowired
	SalesEstimateService estimateService;
	
	// 견적서 목록
	@ResponseBody
	@RequestMapping(value = "/estimateManagement/estimateList")
	public List<SalesEstimateListViewDTO> estimateList(HttpServletRequest req, HttpServletResponse res){
		return estimateService.estimateList(req, res);
	}
	
	// 등록한 거래처 목록
	@ResponseBody
	@RequestMapping(value = "/estimateManagement/registerdEstimateList")
	public List<SalesEstimateListViewDTO> registerdEstimateList(HttpServletRequest req, HttpServletResponse res){
		return estimateService.estimateList(req, res);
	}
}
