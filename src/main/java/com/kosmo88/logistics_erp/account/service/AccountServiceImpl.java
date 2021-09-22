package com.kosmo88.logistics_erp.account.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.account.dao.AccountDAOImpl;
import com.kosmo88.logistics_erp.account.vo.ClientVO;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDAOImpl dao;

	// 기초정보관리
	// 거래처 목록조회
	@Override
	public void clientList(HttpServletRequest request, Model model) {

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
		cnt = dao.getClientCnt();
		System.out.println("거래처 등록 개수 cnt : " + cnt);
		
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
		List<ClientVO> dtos = null;
		// 매개변수 전달한 Map
		Map<String,Object> map = new HashMap<String,Object>();
		
		// 전체글개수가 0보다 크면 리스트정보를 받아온다.
		if (cnt > 0) {
			dtos = new ArrayList<ClientVO>();
			System.out.println("==================");
			System.out.println("dao 전달 start : " + start);
			System.out.println("dao 전달 end : " + end);
			System.out.println("==================");
			map.put("start", start);
			map.put("end", end);
			
			dtos = dao.selectClient(map);
		
		}
		System.out.println("거래처 dtos : " + dtos);
		
		model.addAttribute("dtos", dtos);
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

	
	@Override
	public void clientInsert(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientModifyDetail(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientModifyAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientDeleteAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}
	
	

	// 영업팀 수주요청서 
	// 4번 거래대금 수금확인 요청(영업팀) rx_sale바탕으로 slip테이블 작성(영업팀)
	// 영업팀에서 일반전표 생성하여 회계팀에서 일반전표 변경하면서 매출전표 발생 sales_slip
	
	// 구매팀 발주요청서
	// 11번 구매요청과함께 발주금액 임금요청
	// 일반전표 생성 
	// 매입전표 생성
	
	
	
	

}
