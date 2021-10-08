package com.kosmo88.logistics_erp.account.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AccountService {
	
	// 회계관리 리스트관리 
	//public void accountingList(HttpServletRequest request, Model model);
	
	// 기초정보관리
	// 거래처 목록조회
	public void clientList(Model model);
	
	// 일반전표/장부관리
	// 일반전표 목록조회
	public void slipList(Model model);
	// 일반전표 등록 처리
	//public void slipInsert(Model model);
	// 일반전표 수정처 처리
	public void slipModifyDetail(HttpServletRequest request, Model model);
	// 일반전표 상태변경(승인/미승인)
	public void slipConfirmAction(HttpServletRequest request, Model model);
	// 일반전표 세부내역
	public void slipDetailInfo(HttpServletRequest request, Model model);
	
	
	// 금융자금관리
	// 통장 거래내역(입/출금) 내역조회
	public void accountList(HttpServletRequest req, Model model);
	// 통장 계좌번호 중복검사
	public void accountNumberCheck(HttpServletRequest request, Model model);
	// 신규통장 추가 처리
	public void accountInsertAction(HttpServletRequest request, Model model);
	// 통장 거래내역 추가 단건 추가 처리 페이지(통장정보조회)
	public void accountSimplDetail(HttpServletRequest request, Model model);
	// 통장 거래내역 추가 단건 추가 처리
	public void accountSimplAction(HttpServletRequest request, Model model);
	// 통장 미사용처리
	public void accountEnabledAction(HttpServletRequest request, Model model);
	// 통장 입/출금내역 조회
	public void accountTransactionHistory(HttpServletRequest request, Model model);
	
	// 매입/매출장
	// 매입/매출장 전체목록조회
	public void salesSlipList(Model model);
	// 매입전표 조회
	public void purchaseList(Model model);
	// 매출전표 조회
	public void salesList(Model model);
	
	
	// 결산/제무재표
	// 재무상태표 조회
	public void financialStatementsSelect(Model model);
	// 손익계산서 조회
	public void incomeStatementSelect(Model model);


}
