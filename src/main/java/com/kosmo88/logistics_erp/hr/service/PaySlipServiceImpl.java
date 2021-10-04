package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.PaySlipDAO;

@Service
public class PaySlipServiceImpl implements PaySlipService {

    @Autowired
    PaySlipDAO paySlipDAO;

    @Override
    public void makePaySlip(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void totalPaySlip(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }
}
