package com.kosmo88.logistics_erp.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;

public interface PaySlipService {
    // 전표관리
    // 전표 생성
    void makePaySlip(HttpServletRequest req, HttpServletResponse res);

    // 전표 집계
    ArrayList<PaySlipDTO> totalPaySlip();
}
