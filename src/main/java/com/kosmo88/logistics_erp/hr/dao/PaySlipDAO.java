package com.kosmo88.logistics_erp.hr.dao;

import java.util.List;

import com.kosmo88.logistics_erp.hr.dto.PaySlipDTO;
import com.kosmo88.logistics_erp.hr.dto.PayStepTableDTO;

public interface PaySlipDAO {    
    // 전표관리
    // 전표 생성
    int makePaySlip(PaySlipDTO dto);
    // 전표 집계
    List<PaySlipDTO> totalPaySlip();
}
