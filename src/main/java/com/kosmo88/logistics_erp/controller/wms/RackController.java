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
@RequestMapping(value = "/wms/rack")
public class RackController {
    private static final Logger logger = LoggerFactory.getLogger(RackController.class);

    @RequestMapping(value = {"/list", "/", "/rackList.jsp"})
    public String rackList(Model model) {
        return "wms/rack/rackList";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        return "wms/rack/addRack";
    }
    @RequestMapping(value = "/addAction")
    public String addAction(Model model) {
        return "wms/rack/rackList";
    }

    @RequestMapping(value = "/stock")
    public String stock(Model model) {
        return "wms/rack/stock";
    }

    @RequestMapping("/modify")
    public String modifyRack(){
    	return "wms/rack/rackDetail";
    }
 
    @RequestMapping("/delete")
    public String deleteRack(){
    	return "wms/rack/rackList";
    }

    @RequestMapping(value = {"/view"})
    public String rackDetail(Model model) {
        return "wms/rack/rackDetail";
    }

}