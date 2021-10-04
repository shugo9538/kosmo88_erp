package com.kosmo88.logistics_erp.hr.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.HolidayDAO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceCodeDTO;
import com.kosmo88.logistics_erp.hr.dto.AttendanceDTO;
import com.kosmo88.logistics_erp.hr.dto.CommuteDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayDTO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;
import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.SalaryDTO;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayDAO holidayDAO;

    @Override
    public void leftHolidayNum(HttpServletRequest req, HttpServletResponse res) {
         ArrayList<HolidayUsageStatusDTO> holidayUsageList = (ArrayList<HolidayUsageStatusDTO>) holidayDAO.useHolidayNum();
         
         req.setAttribute("holidayUsageList", holidayUsageList);
    }

    @Override
    public void useHolidayNum(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attendanceTable(HttpServletRequest req, HttpServletResponse res) {
        // TODO Auto-generated method stub

    }
}
