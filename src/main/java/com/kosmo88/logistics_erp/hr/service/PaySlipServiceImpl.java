package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.PaySlipDAO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;

@Service
public class PaySlipServiceImpl implements PaySlipService {

    @Autowired
    PaySlipDAO paySlipDAO;

    @Override
    public void makePaySlip(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<PaySlipDTO> totalPaySlip() {
        return (ArrayList<PaySlipDTO>) paySlipDAO.totalPaySlip();
    }
}
