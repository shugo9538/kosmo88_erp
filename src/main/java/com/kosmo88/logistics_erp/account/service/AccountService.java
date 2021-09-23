package com.kosmo88.logistics_erp.account.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AccountService {
	
	// 회계관리 리스트관리 
	public void accountingList(HttpServletRequest request, Model model);
	
	// 기초정보관리
	// 거래처 목록조회
	//public void clientList(HttpServletRequest request, Model model);
	// 신규 거래처등록
	public void clientInsert(HttpServletRequest request, Model model);
	// 신규 거래처등록 페이지(컨트롤러에서처리)
	// 거래처 정보수정 페이지
	public void clientModifyDetail(HttpServletRequest request, Model model);
	// 거래처 정보수정 처리
	public void clientModifyAction(HttpServletRequest request, Model model);
	// 거리처 목록삭제 페이지(알럿으로 처리)
	// 거래처 목록삭제 처리
	public void clientDeleteAction(HttpServletRequest request, Model model);
	
	// 일반전표/장부관리
	// 일반전표 목록조회
	//public void slipList(HttpServletRequest request, Model model);
	// 일반전표 등록페이지(컨트롤러에서처리)
	// 일반전표 등록
	//public void slipInsert(Model model);
	// 일반전표 수정페이지
	//public void slipModifyDetail(Model model);
	// 일반전표 수정처 처리
	//public void slipModifyAction(Model model);
	// 일반전표 상태변경(승인/미승인)
	//public void slipUpdateState(Model model);
	// 일반전표 삭제처리 페이지
	//public void slipDeleteDetail(Model model);
	// 일반전표 삭제처리
	//public void slipDeleteAction(Model model);
	
	// 금융자금관리
	// 통장 거래내역(입/출금) 내역조회
	//public void accountList(HttpServletRequest request, Model model);
	// 통장 거래내역 추가
	//public void accountInsert(Model model);
	// 통장 입금내역 조회
	//public void accountDeposit(Model model);
	// 통장 출금내역 조회
	//public void accountWithdrawal(Model model);
	// 통장 잔액조회 (전체조회에서 입출금잔액 불러와서 처리)
	// 급여통장 목록조회
	//public void salaryAccountList(Model model);
	// 거래처통장 목록조회
	//public void clientAccountList(Model model);
	
	// 매입/매출장
	// 매입/매출장 전체목록조회
	//public void salesSlipList(Model model);
	// 매입전표 조회
	//public void purchaseList(Model model);
	// 매출전표 조회
	//public void salesList(Model model);
	// 매입/매출전표 추가
	//public void salesSlipInsert(Model model);
	// 매입/매출전표 수정 페이지
	//public void salesSlipModifyDetail(Model model);
	// 매입/매출전표 수정 처리
	//public void salesSlipModifyAction(Model model);
	// 매입/매출전표 삭제처리페이지
	//public void salesSlipDeletaDetail(Model model);
	// 매입/매출전표 삭제처리
	//public void salesSlipDeletaDetailAction(Model model);
	
	// 결산/제무재표
	// 재무상태표 조회
	//public void financialStatementsSelect(Model model);
	// 손익계산서 조회
	//public void incomeStatementSelect(Model model);


}
