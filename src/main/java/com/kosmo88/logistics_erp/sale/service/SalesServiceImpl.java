package com.kosmo88.logistics_erp.sale.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dao.SalesDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;

import oracle.sql.DATE;

@Service
public class SalesServiceImpl implements SalesService{

	@Autowired
	SalesDAO dao;
	
	// 거래처 등록
	@Override
	public void clientResister(HttpServletRequest request, Model model) {
		
		SalesClientDTO dto = new SalesClientDTO();
		
		dto.setName(request.getParameter("name"));
		dto.setCeo_name(request.getParameter("ceo_name"));
		// 연락처는 나중에 추가
		dto.setEmail(request.getParameter("email"));
		
		int phone = 0;
		int phone1 = Integer.parseInt(request.getParameter("phone1"));
		int phone2 = Integer.parseInt(request.getParameter("phone2"));
		int phone3 = Integer.parseInt(request.getParameter("phone3"));
		phone = phone1 + phone2 + phone3;
		dto.setPhone(phone);
		
		
		long register_num = 0;
		long register_num1 = Long.parseLong(request.getParameter("register_num1"));
		long register_num2 = Long.parseLong(request.getParameter("register_num2"));
		long register_num3 = Long.parseLong(request.getParameter("register_num3"));
		register_num = register_num1 + register_num2 + register_num3;
		dto.setRegister_num(register_num);
		
		dto.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		dto.setAddress(request.getParameter("address"));
		dto.setDetail_address(request.getParameter("detail_address"));
		
		int insertCnt = dao.registerClient(dto);
		System.out.println("insertCnt : " + insertCnt);
		
		model.addAttribute("insertCnt", insertCnt);
		
		
	}

	// 거래처 목록
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
		
		System.out.println("cnt : " + cnt);
		cnt = dao.getClientCnt();
		System.out.println("거래처 갯수 cnt : " + cnt);
		
		pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1"; // 첫 페이지를 1페이지로 지정
		}
		
		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum);
		System.out.println("currentPage : " + currentPage);
		
		// 페이지 갯수 6= (30 / 5) + (0)
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0); // 페이지갯수 + 나머지 있으면 1페이지
		
		// 현재페이지 시작 글번호(페이지별)
		// start = (currentPage - 1) * pageSize + 1;
		// 1 = (1 -1) * 5 + 1
		start = (currentPage -1) * pageSize + 1;
		
		// 현재페이지 마지막 글번호(페이지별)
		// end = start + pageSize - 1;
		// 5 = 1 + 5 - 1
		end = start + pageSize - 1;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		// 출력용 글번호
		// 30 = 30 - (1 - 1) * 5; // 1페이지
		// number = cnt - (currentPage - 1) * pageSize;
		number = cnt - (currentPage - 1) * pageSize;
		System.out.println("number : " + number);
		
		// 시작페이지
		// 1 = (1 / 3) * 3 + 1;
		// startPage = (currentPage / pageBlock) * pageBlock + 1;
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0) startPage -= pageBlock;
		System.out.println("startPage : " + startPage);
		
		
		// 마지막 페이지
		// 3 = 1 + 3 - 1
		endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) endPage = pageCount;
		
		System.out.println("endPage : " + endPage);
		
		System.out.println("==================================");
		
		List<SalesClientDTO> dto = null;
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		if(cnt > 0) {
			map.put("start", start);
			map.put("end", end);
			
			// 거래처 목록을 List에 담는다.
			dto = dao.getClientList(map);
		}
		
		model.addAttribute("dto", dto);
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
	}

	// 거래처 상세 정보
	@Override
	public void clientDetail(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		SalesClientDTO dto = dao.getClientDetail(id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
	}
	
	// 거래처 수정
	@Override
	public void updateClient(HttpServletRequest request, Model model) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		SalesClientDTO dto = new SalesClientDTO();
		
		dto = dao.getClientDetail(id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
	}

	// 거래처 수정 처리 
	@Override
	public void updateClientAction(HttpServletRequest request, Model model) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		SalesClientDTO dto = new SalesClientDTO();
		
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setCeo_name(request.getParameter("ceo_name"));
		dto.setPhone(Integer.parseInt(request.getParameter("phone")));
		dto.setEmail(request.getParameter("email"));
		dto.setRegister_num(Integer.parseInt(request.getParameter("register_num")));
		dto.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		dto.setAddress(request.getParameter("address"));
		dto.setDetail_address(request.getParameter("detail_address"));
		//dto.setRegister_date(Date.parse(request.getParameter("register_date")));
		
		int updateCnt = dao.updateClient(dto);
		System.out.println("updateCnt : " + updateCnt);
		
		model.addAttribute("updateCnt", updateCnt);
		model.addAttribute("pageNum", pageNum);
	}
	
	// 거래처 삭제
	@Override
	public void deleteClient(HttpServletRequest request, Model model) {
		
	}

	

	@Override
	public void deleteClientAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	


	

	
}
