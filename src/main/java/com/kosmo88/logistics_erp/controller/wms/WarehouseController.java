package com.kosmo88.logistics_erp.controller.wms;

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
@RequestMapping(value = "/wms/warehouse")
public class WarehouseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @RequestMapping(value = {"/list", "/"})
    public String warehouseList(Model model) {
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "wms/warehouse/addWarehouse";
    }
    @RequestMapping(value = "/addAction")
    public String addAction(Model model) {
        return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
        return "wms/warehouse/stock";
    }

    @RequestMapping("/modify")
    public String modifyWarehouse(){
    	return "wms/warehouse/warehouseDetail";
    }
 
    @RequestMapping("/delete")
    public String deleteWarehouse(){
    	return "wms/warehouse/warehouseList";
    }

    @RequestMapping(value = {"/view"})
    public String warehouseDetail(Model model) {
        return "wms/warehouse/warehouseDetail";
    }

    @RequestMapping("/rack")
    public String rack(){
    	return "";
    }
   

}