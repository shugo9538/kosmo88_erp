package com.kosmo88.logistics_erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
@SessionAttributes({ "session", "userid" })
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    // 구매관리
    @RequestMapping(value = "/purchaseManagement")
    public String configurations(Model model) {

        return "purchase/purchaseManagement";
    }

    // 거래처 관리
    @RequestMapping(value = "/clientManagement")
    public String hrManagement(Model model) {

        return "purchase/clientManagement";
    }

    // 발주 현황
    @RequestMapping(value = "/orderManagement")
    public String attendanceManagement(Model model) {

        return "purchase/orderManagement";
    }

    // 구매 관리 현황
    @RequestMapping(value = "/currentStatus")
    public String holidayManagement(Model model) {

        return "purchase/currentStatus";
    }
}
