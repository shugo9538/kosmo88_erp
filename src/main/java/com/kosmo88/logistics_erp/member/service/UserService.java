package com.kosmo88.logistics_erp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface UserService {
    // 회원가입 처리
    public void signinAction(HttpServletRequest req, Model model);
    
    // ml chart
    public void showChart(HttpServletRequest req, Model model) throws Exception;
}
