package com.kosmo88.logistics_erp.account.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.account.code.menuCode;
import com.kosmo88.logistics_erp.account.dao.AccountDAO;
import com.kosmo88.logistics_erp.account.dto.AccountDTO;
import com.kosmo88.logistics_erp.account.dto.BalanceDTO;
import com.kosmo88.logistics_erp.account.dto.ClientDTO;
import com.kosmo88.logistics_erp.account.dto.AccountHistoryDTO;
import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SalesSlipDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;

@Service
public class AccountServiceImpl implements AccountService, menuCode {
	
	@Autowired
	AccountDAO accountDAO;

	// 기초정보관리
	// 거래처 목록조회
	@Override
	public void accountingList(HttpServletRequest request, Model model) {

		// 거래처 목록조회 페이징 처리
		int pageSize = 5;// 한 페이지당 출력할 글 개수
		int pageBlock = 3; // 한 블럭당 페이지 개수
		
		int cnt = 0;// 전체글 개수
		int start = 0;// 현재(각)페이지 시작 글번호
		int end = 0;// 현재(각)페이지 마지막 글번호
		int number = 0; // 출력용 글번호
		String pageNum = "0"; //페이지 번호
		int currentPage=0; //현제페이지 번호
		
		int pageCount = 0; //페이지 개수
		int startPage = 0; //시작페이지
		int endPage = 0; //마지막 페이지
		
		// 1. 거래처 등록 개수 조회
		int categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
		System.out.println("화면에서 받은 categoryNum");
		System.out.println("=================");
		
		switch (categoryNum) {
			case CLIENT://거래처
			cnt = accountDAO.getClientCnt();
			System.out.println("accountDAO : " + CLIENT);
			break;
			case SLIP://일반전표
			cnt = accountDAO.getSlipCnt();
			System.out.println("accountDAO : " + SLIP);
			break;
			case SALES://매출전표
			cnt = accountDAO.getSalesPurchaseCnt(SALES_NAME);
			System.out.println("accountDAO : " + SALES);
			break;
			case PURCHASE://매입전표
			cnt = accountDAO.getSalesPurchaseCnt(PURCHASE_NAME);
			System.out.println("accountDAO : " + PURCHASE);
			break;
			case SALESSLIP://매입/매출전표
			cnt = accountDAO.getSalesSlipCnt();
			System.out.println("accountDAO : " + SALESSLIP);
			break;
			case ACCOUNT://계좌
			cnt = accountDAO.getAccountCnt();
			System.out.println("accountDAO : " + ACCOUNT);
			break;
		
		}
		System.out.println("건수조회 cnt : " + cnt);
		
		// 2. 페이지번호(페이지이동시 전화면세서 가지고와서 대입)
		pageNum = request.getParameter("pageNum");
		System.out.println("화면에서 받아온 페이지번호 pageNum : " + pageNum);
		if(pageNum == null) {
			pageNum = "1";
			System.out.println("페이지번호가 없을때 pageNum 1 : " + pageNum);
		}
		
		// 전체글개수 예) 30개일경우
		// 2. 현재 페이지 번호
		currentPage = Integer.parseInt(pageNum);	
		System.out.println("현재페이지 번호 currentPage : " + currentPage);
	
		// 3. 전체페이지 개수 (전체글개수 / 페이지에서 출력할 글개수) + (전체글개수 % 출력할 글개수 나머지가 0 이상이면 한페이지를 추가한다.)
		// 페이지 개수 6 = ( 30 / 5 ) + ( 0 )    
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);
		System.out.println("페이지 개수 pageCount : " + pageCount);
	
		// 4. 현재페이지 시작 글번호(페이지별)
		// 1 = (1 - 1) * 5 + 1;
		start = (currentPage - 1) * pageSize + 1;
		System.out.println("페이지 시작글번호 start : " + start);
		
		// 5. 현제페이지 마지막 글번호(페이지별)
		// 5 = (1 + 5) - 1;
		end = (start + pageSize) - 1;
		System.out.println("페이지 마지막 글번호 end : " + end);
		
		// 6. 출력용 글번호 
		// 출력용 글번호 = 전체글개수 - (현재페이지번호 - 1) * 출력할 페이지개수
		// 30 = 30 - (1-1) * 5;
		number = cnt - (currentPage - 1) * pageSize;
		System.out.println("출력용 글번호 number : " + number);
		
		// 7. 시작페이지
		// 시작페이지 = (현재페이지 / 페이지블랙개수) * 페이지블랙개수 + 1;
		// 1= (1/3) * 3 + 1;
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0) startPage -= pageBlock;
		System.out.println("시작페이지 startPage : " + startPage);
		// 8. 마지막 페이지 
		// 마지막페이지 = 시작페이지 + 페이지블랙개수 - 1
		// 3 = 1 + 3 - 1
		endPage = currentPage + pageBlock - 1;
		if (endPage > pageCount) endPage = pageCount;
		System.out.println("마지막페이지 endPage : " + endPage);
		
		// 리턴받을 List
		List<ClientDTO> client = null;
		List<SlipDTO> slip = null;
		List<SalesSlipDTO> saleslip = null;
		List<AccountDTO> account = null;
		
		// 매개변수 전달한 Map
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 전체글개수가 0보다 크면 리스트정보를 받아온다.
		if (cnt > 0) {
			System.out.println("==================");
			System.out.println("dao 전달 start : " + start);
			System.out.println("dao 전달 end : " + end);
			System.out.println("==================");
			map.put("start", start);
			map.put("end", end);
			
			// 거래처관리
			if (categoryNum == CLIENT) {
				client = new ArrayList<ClientDTO>();
				client = accountDAO.selectClient(map);
			// 일반전표
			}else if(categoryNum == SLIP) {
				slip = new ArrayList<SlipDTO>();
				slip = accountDAO.selectSlip(map);
			// 매출전표 목록	
			}else if (categoryNum == SALES) {
				map.put("type", SALES_NAME);
				saleslip = new ArrayList<SalesSlipDTO>();
				saleslip = accountDAO.selectSalesPurchase(map);
			// 매입전표 목록	
			}else if (categoryNum == PURCHASE) {
				map.put("type", PURCHASE_NAME);
				saleslip = new ArrayList<SalesSlipDTO>();
				saleslip = accountDAO.selectSalesPurchase(map);
			// 매입/매출 전체목록
			}else if(categoryNum == SALESSLIP) {
				saleslip = new ArrayList<SalesSlipDTO>();
				saleslip = accountDAO.selectSalesSlip(map);
			// 계좌조회
			}else if(categoryNum == ACCOUNT) {
				account = new ArrayList<AccountDTO>();
				account = accountDAO.selectAccount(map);
			}
				
		}
		System.out.println("거래처 dtos : " + client);
		System.out.println("일반전표 dtos : " + slip);
		System.out.println("매입/매출 전표 dtos : " + saleslip);
		System.out.println("계좌조회 dtos : " + account);
		
		// 거래처
		model.addAttribute("client", client);
		// 일반전표
		model.addAttribute("slip", slip);
		// 매입 매출전표 
		model.addAttribute("saleslip", saleslip);
		// 계좌조회
		model.addAttribute("account", account);
		
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		
		// 전체글개수가 0보다 크면 각 페이지정보를 생성한다.
		if (cnt > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currentPage", currentPage);
		}
		System.out.println("다음페이지 통과 ");
	}
	
	// ------------------------------ 금융/자금관리 ------------------------------
	// 신규통장 추가 처리
	@Override
	public void accountInsertAction(HttpServletRequest request, Model model) {
		
		// accountNewDetail.jsp에서 입력받은 값 
		
		int account_holder_id = Integer.parseUnsignedInt(request.getParameter("account_holder_id")); // 관계테이블 FK
		String name = request.getParameter("name"); // 계좌명
		String account_number = request.getParameter("account_number"); // 계좌번호
		String bank = request.getParameter("bank"); // 계좌은행
		int balance = Integer.parseInt(request.getParameter("balance")); // 기초잔액
		//String account_resister_date = request.getParameter("account_resister_date"); // 통장개설일
		//System.out.println("통장등록일" + account_resister_date);
		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_holder_id(account_holder_id);
		accountDTO.setName(name);
		accountDTO.setAccount_number(account_number);
		accountDTO.setBank(bank);
		accountDTO.setBalance(balance);
		accountDTO.setRegister(new Date(System.currentTimeMillis()));
		
		System.out.println("계좌소유 : " + account_holder_id);
		System.out.println("계좌명 : " + name);
		System.out.println("계좌번호 : " + account_number);
		System.out.println("계좌은행 : " + bank);
		System.out.println("기초잔액" + balance);
		
		int insertCnt = 0;
		insertCnt = accountDAO.insertAccount(accountDTO);
		
		System.out.println("신규통장 추가2 : " + insertCnt);
		
		if (insertCnt > 0) {
			System.out.println("insertCnt 성공 : " + insertCnt );
			model.addAttribute("insertCnt", insertCnt);
		}else {
			System.out.println("insertCnt 실패 : " + insertCnt );
			model.addAttribute("insertCnt", insertCnt);
		}
		System.out.println("신규통장 추가3 : " + insertCnt);
		
	}
	// 통장 거래내역 추가 단건 추가 처리 페이지(통장정보조회)
	@Override
	public void accountSimplDetail(HttpServletRequest request, Model model) {
		
		List<AccountDTO> account = new ArrayList<AccountDTO>(); 
		
		account = accountDAO.selectAccountInfo();
		System.out.println("통장 정보 조회 : " + account);
		
		model.addAttribute("account", account);
		
	}
	// 통장 거래내역 추가 단건 추가 처리
	@Override
	public void accountSimplAction(HttpServletRequest request, Model model) {
		
		// accountSimplDetail.jsp 화면에서 받아온값
		AccountHistoryDTO ahDTO = new AccountHistoryDTO();
		
		String account_number = request.getParameter("account_number");
		String type = request.getParameter("type"); // 입출금 유형
		int balance = Integer.parseInt(request.getParameter("balance")); // 입금
		String abs = request.getParameter("abs"); //적요 abstract 예약어로 앞 세글자로 변경 abs
		String transaction_date = request.getParameter("transaction_date"); // 거래일자
		String transaction_time = request.getParameter("transaction_time"); // 거래시간
		
		String t_date = transaction_date.substring(2);
		System.out.println("t_date : " + t_date); //앞 2자리 지우기
		
		
		//날짜 변경하여 입력하기
		String [] t_str = transaction_date.split("/");
		
		String StrDate1 = t_str[0]; 
		String StrDate2 = t_str[1];
		String StrDate3 = t_str[2];
		System.out.println(StrDate1);
		System.out.println(StrDate2);
		System.out.println(StrDate3);
		
		
		
		System.out.println("통장거래내역추가 account_number : "+ account_number);
		System.out.println("통장거래내역추가 type : "+ type);
		System.out.println("통장거래내역추가 balance : "+ balance);
		System.out.println("통장거래내역추가 abs : "+ abs);
		System.out.println("통장거래내역추가 transaction_time :  "+ transaction_time);
		System.out.println("통장거래내역추가 transaction_date :  "+ transaction_date);
		
		int insertCnt = 0;
		if (account_number != null) {
			
			ahDTO.setAccount_number(account_number);
			ahDTO.setType(type);
			ahDTO.setBalance(balance);
			ahDTO.setAbs(abs);
			ahDTO.setTransaction_date(t_date);
			
			insertCnt = accountDAO.insertAcountHistory(ahDTO);
			
		}
		System.out.println("통장 거래내역 추가 : " + insertCnt);
		model.addAttribute("insertCnt", insertCnt);
		
	}

	// 통장 입출금내역조회
	@Override
	public void accountTransactionHistory(HttpServletRequest request, Model model) {
		
		//accountList.jsp 에서 전달받은 값
		String account_number = request.getParameter("account_number");
		System.out.println("통장 입출금내역1 : " + account_number);
		
		//List<DepositWithdrawalHistoryDTO> depositWithdrawalHistoryDTO = new ArrayList<DepositWithdrawalHistoryDTO>();
		//depositWithdrawalHistoryDTO = accountDAO.selectDepositWithdrawalHistory(account_number);
		//model.addAttribute("dtos", depositWithdrawalHistoryDTO);
		//System.out.println("통장입출금내역 dtos : " + depositWithdrawalHistoryDTO);
		
		List<BalanceDTO> balanceDTO = new ArrayList<BalanceDTO>();
		
		balanceDTO = accountDAO.selectAccountBalance(account_number); 

		model.addAttribute("dtos", balanceDTO);
		System.out.println("잔액조회 balanceDTO : " + balanceDTO);
	}
	// 통장 입금내역 조회
	@Override
	public void accountDeposit(HttpServletRequest request, Model model) {

		//accountDetail.jsp 에서 전달받은 값
		//String account_number = request.getParameter("account_number");
		//List<DepositWithdrawalHistoryDTO> depositWithdrawalHistoryDTO = new ArrayList<DepositWithdrawalHistoryDTO>();
		//depositWithdrawalHistoryDTO = accountDAO.selectAccountDeposit(account_number);
		//model.addAttribute("DepositWithdrawalHistoryDTO", depositWithdrawalHistoryDTO);
	}

	// 통장 출금내역 조회
	@Override
	public void accountWithdrawal(HttpServletRequest request, Model model) {
		
		//accountDetail.jsp 에서 전달받은 값
		//String account_number = request.getParameter("account_number");
		//List<DepositWithdrawalHistoryDTO> depositWithdrawalHistoryDTO = new ArrayList<DepositWithdrawalHistoryDTO>();
		//depositWithdrawalHistoryDTO = accountDAO.selectAccountWithdrawal(account_number);
		//System.out.println("잔액조회 depositWithdrawalHistoryDTO : " + depositWithdrawalHistoryDTO);
		//model.addAttribute("depositWithdrawalHistoryDTO", depositWithdrawalHistoryDTO);
		
	}
	
	// ------------------------------ 결산/재무제표 ------------------------------
	// 재무상태표
	@Override
	public void financialStatementsSelect(Model model) {
		
		FinancialStatementsDTO finan = new FinancialStatementsDTO();
		
		finan = accountDAO.selectFinancialStatements();
		
		model.addAttribute("dto", finan);
		
	}
	// 손익계산서
	@Override
	public void incomeStatementSelect(Model model) {
		
		IncomeStatementDTO income = new IncomeStatementDTO();
		
		income = accountDAO.selectIncomeStatement();
		
		model.addAttribute("dto", income);
	}













	
	
	// 영업팀 수주요청서 
	// 4번 거래대금 수금확인 요청(영업팀) rx_sale바탕으로 slip테이블 작성(영업팀)
	// 영업팀에서 일반전표 생성하여 회계팀에서 일반전표 변경하면서 매출전표 발생 sales_slip
	
	// 구매팀 발주요청서
	// 11번 구매요청과함께 발주금액 임금요청
	// 일반전표 생성 
	// 매입전표 생성
	
	
	
	

}
