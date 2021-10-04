package com.kosmo88.logistics_erp.hr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PaySlipService {
    // 전표관리
    // 전표 생성
    void makePaySlip(HttpServletRequest req, HttpServletResponse res);

    // 전표 집계
    void totalPaySlip(HttpServletRequest req, HttpServletResponse res);
}
