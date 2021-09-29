package com.kosmo88.logistics_erp.wms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kosmo88.logistics_erp.wms.service.WarehouseService;

//@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/wms/warehouse")
public class WarehouseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    WarehouseService warehouseService;

    @RequestMapping(value = {"/list", "/"})
    public String list(Model model) {
    	warehouseService.list(model);
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
    	warehouseService.add();
        return "wms/warehouse/addWarehouse";
    }
    @RequestMapping(value = "/addAction")
    public String addAction(Model model) {
    	warehouseService.addAction();
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
    	warehouseService.stock();
        return "wms/warehouse/stock";
    }

    @RequestMapping("/modify")
    public String modify(){
    	warehouseService.modify();
    	return "wms/warehouse/modifyWarehouse";
    }
 
    @RequestMapping("/delete")
    public String delete(){
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