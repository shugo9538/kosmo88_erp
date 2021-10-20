package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.DepartmentCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.HRCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;
import com.kosmo88.logistics_erp.hr.dto.PositionCodeDTO;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    ConfigurationDAO configurationDAO;

    @Override
    public ArrayList<HRCodeDTO> selectHRCode() {
        return (ArrayList<HRCodeDTO>) configurationDAO.selectHRCode();
    }

    @Override
    public ArrayList<DepartmentCodeDTO> selectDepartments() {
        return (ArrayList<DepartmentCodeDTO>) configurationDAO.selectDepartments();
    }

    @Override
    public ArrayList<PositionCodeDTO> selectPosition() {
        return (ArrayList<PositionCodeDTO>) configurationDAO.selectPosition();
    }

    @Override
    public ArrayList<AttendanceCodeDTO> selectAttendanceCode() {
        return (ArrayList<AttendanceCodeDTO>) configurationDAO.selectAttendanceCode();
    }

    @Override
    public ArrayList<PayStepTableDTO> selectAnnualSalary() {
        return (ArrayList<PayStepTableDTO>) configurationDAO.selectAnnualSalary();
    }

    @Override
    public void insertHRCode(HRCodeDTO dto) {
        configurationDAO.insertHRCode(dto);
    }
//
//    @Override
//    public void employeeHasHoliday(HttpServletRequest req, HttpServletResponse res) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void manageSalary(HttpServletRequest req, HttpServletResponse res) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void salayStepTable(HttpServletRequest req, HttpServletResponse res) {
//        // TODO Auto-generated method stub
//
//    }
}
