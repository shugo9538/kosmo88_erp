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
@RequestMapping(value = "/truck")
public class TruckController {
    private static final Logger logger = LoggerFactory.getLogger(TruckController.class);


    // 차량 관리
    @RequestMapping(value = {"/truckList.do", "/"})
    public String carManagement(Model model) {

        return "logistics/truck/truckList";
    }


}