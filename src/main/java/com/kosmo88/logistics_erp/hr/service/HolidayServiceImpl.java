package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo88.logistics_erp.hr.dao.HolidayDAO;
import com.kosmo88.logistics_erp.hr.dto.HolidayUsageStatusDTO;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    HolidayDAO holidayDAO;
    
    // 휴가 잔여일수 현황
    @Override
    public ArrayList<HolidayUsageStatusDTO> leftHolidayNum() {
        return (ArrayList<HolidayUsageStatusDTO>) holidayDAO.leftHolidayNum();
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
