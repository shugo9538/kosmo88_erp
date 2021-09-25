package com.kosmo88.logistics_erp.wms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/wms/stock")
public class StockController {
    private static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @RequestMapping(value = {"/list", "/"})
    public String stock(Model model) {
        return "wms/stock/stockList";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "wms/stock/addStock";
    }
    @RequestMapping(value = "/addAction")
    public String addAction(Model model) {
        return "wms/stock/stockList";
    }


    @RequestMapping("/modify")
    public String modify(){
    	return "wms/stock/stockDetail";
    }
 
    @RequestMapping("/delete")
    public String delete(){
    	return "wms/stock/stockList";
    }

    @RequestMapping("/view")
    public String view(Model model) {
        return "wms/stock/stockDetail";
    }

    @RequestMapping("/rack")
    public String rack(){
    	return "";
    }
   

}