package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO;
import com.kosmo88.logistics_erp.hr.dao.EmployeeDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.EmployeeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public ArrayList<EmployeeDTO> employeeManagement() {
        return (ArrayList<EmployeeDTO>) employeeDAO.employeeList();
    }

    @Override
    public ArrayList<DepartmentCodeDTO> departmentCodeManagement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<PositionCodeDTO> positionCodeManagement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<AttendanceCodeDTO> attendanceCodeManagement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void hrCodeManagement(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertAttendanceCode(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void manageSalary(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void salayStepTable(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub
        
    }

}
