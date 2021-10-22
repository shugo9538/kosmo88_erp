package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.EmployeeDAO;
import com.kosmo88.logistics_erp.hr.dao.SalaryDAO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;
import com.kosmo88.logistics_erp.hr.dto.SearchEmployeeDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryDAO salaryDAO;
    
    @Autowired
    EmployeeDAO employeeDAO;
    
    QueryCode queryCode;

    @Override
    public ArrayList<SalaryDTO> monthlyPaymentAndStatus() {
        return (ArrayList<SalaryDTO>) salaryDAO.monthlyPaymentAndStatus();
    }

    
    @Override
    public void selectEmployee(HttpServletRequest req, HttpServletResponse res) {
        List<SearchEmployeeDTO> dtos = employeeDAO.searchEmployeeList();
        
        req.setAttribute("dtos", dtos);
    }


    @Override
    public void salaryStatistics(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void earnedIncome(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }


    @Override
    public boolean insertSalaryAction(SalaryDTO dto) {
        queryCode = QueryCode.INSERT;
        Date d = dto.getPayday();
        
        dto.setPayday(new java.sql.Date(d.getYear(), d.getMonth(), d.getDate()));
        dto.setPayment_status("입금대기");
        return queryCode.check(salaryDAO.insertSalaryAction(dto));
    }
}
