package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.ConfigurationDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    ConfigurationDAO configurationDAO;

    @Override
    public void attendanceCodeManagement(HttpServletRequest req, HttpServletResponse res) {
        ArrayList<AttendanceCodeDTO> attendanceCodeList = (ArrayList<AttendanceCodeDTO>) configurationDAO.attendanceCodeList();

        req.setAttribute("acList", attendanceCodeList);
    }

    @Override
    public void insertAttendanceCode(HttpServletRequest req, HttpServletResponse res) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String enabled = req.getParameter("enabled");

        AttendanceCodeDTO dto = new AttendanceCodeDTO(id, name, type, enabled.charAt(0));

        configurationDAO.insertAttendanceCode(dto);
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
