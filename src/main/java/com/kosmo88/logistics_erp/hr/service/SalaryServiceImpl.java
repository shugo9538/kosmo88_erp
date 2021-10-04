package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.SalaryDAO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryDAO salaryDAO;

    @Override
    public ArrayList<SalaryDTO> monthlyPaymentAndStatus() {
        return (ArrayList<SalaryDTO>) salaryDAO.monthlyPaymentAndStatus();
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
