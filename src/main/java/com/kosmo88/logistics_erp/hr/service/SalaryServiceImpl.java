package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.SalaryDAO;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryDAO salaryDAO;

    @Override
    public void monthlyPaymentAndStatus(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void salaryStatistics(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void earnedIncome(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }
}
