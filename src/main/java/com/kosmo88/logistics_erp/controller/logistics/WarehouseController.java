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

    @RequestMapping(value = {"/warehouseList", "/"})
    public String warehouseList(Model model) {
        return "wms/warehouse/warehouseList";
    }
    @RequestMapping(value = {"/addWarehouse.do"})
    public String addWarehouse(Model model) {
<<<<<<< HEAD
        return "wms/warehouse/addWarehouse";
    }
    @RequestMapping(value = {"/itemList.do"})
    public String itemList(Model model) {
        return "wms/warehouse/itemList";
=======
        return "wms/addWarehouse";
    }
    @RequestMapping(value = {"/itemList.do"})
    public String itemList(Model model) {
        return "wms/itemList";
>>>>>>> f64f03fd7394f857afc5fa5c4e064c84de6ee17d
    }

}