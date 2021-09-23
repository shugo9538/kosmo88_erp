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
@RequestMapping(value = "/wms/truck")
public class TruckController {
    private static final Logger logger = LoggerFactory.getLogger(TruckController.class);

    @RequestMapping(value = {"/list", "/"})
    public String list(Model model) {
        return "wms/truck/truckList";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "wms/truck/addTruck";
    }
    @RequestMapping(value = "/addAction")
    public String addAction(Model model) {
        return "wms/truck/truckList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
        return "wms/truck/stock";
    }

    @RequestMapping("/modify")
    public String modify(){
    	return "wms/truck/truckDetail";
    }
 
    @RequestMapping("/delete")
    public String delete(){
    	return "wms/truck/truckList";
    }

    @RequestMapping(value = {"/view"})
    public String Detail(Model model) {
        return "wms/truck/truckDetail";
    }

    @RequestMapping("/rack")
    public String rack(){
    	return "";
    }
   

}