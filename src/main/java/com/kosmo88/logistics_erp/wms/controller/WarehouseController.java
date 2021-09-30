package com.kosmo88.logistics_erp.wms.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.dto.RackDto;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.service.RackService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;
import com.kosmo88.logistics_erp.wms.util.DtoFunction;
import com.kosmo88.logistics_erp.wms.util.MyLog;


//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/wms/warehouse")
public class WarehouseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    
    @Autowired
    WarehouseService warehouseService;
   
    @Autowired
    RackService rackService;


    @RequestMapping(value = "/add")
    public String add() {
        return "wms/warehouse/addWarehouse";
    }
    
    @RequestMapping(value = {"/list", "/"})
    public String list(Model model) {
    	warehouseService.list();
        return "wms/warehouse/warehouseList";
    }


	@RequestMapping(value = "/addAction")
    public String addAction(HttpServletRequest req, Model model) {
     	Map<String, String[]> paramMap = req.getParameterMap();
     	MyLog.logParamMap(paramMap);
     	System.out.println("파라미터 맵 값 : " + paramMap);
    	int warehouseId = warehouseService.addAction(paramMap);
    	rackService.addAction(paramMap, warehouseId);
    	
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
    	warehouseService.stock();
        return "wms/warehouse/stock";
    }

    @RequestMapping("/modify")
    public String modify(Model model){
    	warehouseService.modify();
    	return "wms/warehouse/modifyWarehouse";
    }
 
    @RequestMapping("/delete")
    public String delete(Model model){
    	warehouseService.delete();
    	return "wms/warehouse/warehouseList";
    }

    @RequestMapping("/view")
    public String view(Model model) {
    	warehouseService.view();
        return "wms/warehouse/warehouseDetail";
    }
    @RequestMapping("/viewRack")
    public String viewRack(Model model) {
    	warehouseService.viewRack();
        return "wms/warehouse/rackDetail";
    }

//    @RequestMapping("/rack")
//    public String rack(){
//    	return "";
//    }

}