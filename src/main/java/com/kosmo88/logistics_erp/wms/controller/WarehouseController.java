package com.kosmo88.logistics_erp.wms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.dao.WarehouseDao;
import com.kosmo88.logistics_erp.wms.dto.WarehouseDto;
import com.kosmo88.logistics_erp.wms.service.RackService;
import com.kosmo88.logistics_erp.wms.service.WarehouseService;

import dtoFunction.DtoFunction;

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
     	WarehouseDto warehouseDto = new WarehouseDto();
//    	제네릭 타입을 Object,Object로 바꿔야 할 수도 있다
    	DtoFunction.setDtoWithParameterMap(req.getParameterMap(), warehouseDto);
     	warehouseDto.setAddress(req.getParameter("basicAddr") + req.getParameter("detailAddr"));
    	warehouseService.addAction(warehouseDto);
    	
    	int RackCnt = 0;
    	for(int i = 0; i < RackCnt; i++) {
    		rackService.add();
    	}
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