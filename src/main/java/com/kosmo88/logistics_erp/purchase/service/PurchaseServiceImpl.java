package com.kosmo88.logistics_erp.purchase.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDAO purchaseDao;


}
