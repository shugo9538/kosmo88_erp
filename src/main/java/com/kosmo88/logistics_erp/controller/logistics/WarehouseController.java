package com.kosmo88.logistics_erp.controller.logistics;

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
@RequestMapping(value = "/wms")
public class WarehouseController {
    private static final Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @RequestMapping(value = {"/warehouseList.do", "/"})
    public String warehouseList(Model model) {
        return "logistics/wms/warehouseList";
    }
    @RequestMapping(value = {"/addWarehouse.do"})
    public String addWarehouse(Model model) {
        return "logistics/wms/addWarehouse";
    }
    @RequestMapping(value = {"/itemList.do"})
    public String itemList(Model model) {
        return "logistics/wms/itemList";
    }

}