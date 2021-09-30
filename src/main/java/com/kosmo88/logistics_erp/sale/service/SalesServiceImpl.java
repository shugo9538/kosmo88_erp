package com.kosmo88.logistics_erp.sale.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dao.SalesDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;


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
		
		String email = "";
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		email = email1 + "@" + email2;
		dto.setEmail(email);
		
		String phone = "";
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		phone = phone1 + "-" + phone2 + "-" + phone3; 
		dto.setPhone(phone);
		
		
		String register_num = "";
		String register_num1 = request.getParameter("register_num1");
		String register_num2 = request.getParameter("register_num2");
		String register_num3 = request.getParameter("register_num3");
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
		
		int cnt = 0;// 전체글 개수
		
		cnt = dao.getClientCnt();
		System.out.println("거래처 갯수 cnt : " + cnt);
		
		List<SalesClientDTO> dto = null;
		
		if(cnt > 0) {
			dto = dao.getClientList();
		}
		
		model.addAttribute("dto", dto);
		model.addAttribute("cnt", cnt);
		
	}

	// 거래처 상세 정보
	@Override
	public void clientDetail(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		SalesClientDTO dto = dao.getClientDetail(id);
		
		model.addAttribute("dto", dto);
	}
	
	// 거래처 수정
	@Override
	public void updateClient(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		SalesClientDTO dto = new SalesClientDTO();
		
		dto = dao.getClientDetail(id);
		
		model.addAttribute("dto", dto);
	}

	// 거래처 수정 처리 
	@Override
	public void updateClientAction(HttpServletRequest request, Model model) {
		
		SalesClientDTO dto = new SalesClientDTO();
		
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setCeo_name(request.getParameter("ceo_name"));
		
		String phone = "";
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		phone = phone1 + "-" + phone2 + "-" + phone3; 
		dto.setPhone(phone);
		
		dto.setEmail(request.getParameter("email"));

		String register_num = "";
		String register_num1 = request.getParameter("register_num1");
		System.out.println(request.getParameter("register_num1") );
		
		String register_num2 = request.getParameter("register_num2");
		String register_num3 = request.getParameter("register_num3");
		register_num = register_num1 + "-" + register_num2 + "-" + register_num3;
		dto.setRegister_num(register_num);
		
		dto.setZip_code(Integer.parseInt(request.getParameter("zip_code")));
		dto.setAddress(request.getParameter("address"));
		dto.setDetail_address(request.getParameter("detail_address"));
		//dto.setRegister_date(Date.parse(request.getParameter("register_date")));
		
		int updateCnt = dao.updateClient(dto);
		System.out.println("updateCnt : " + updateCnt);
		
		model.addAttribute("updateCnt", updateCnt);
	}
	
	// 거래처 삭제
	@Override
	public void deleteClient(HttpServletRequest request, Model model) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		int deleteCnt = dao.deleteClient(id);
		System.out.println("updateCnt : " + deleteCnt);
		
		model.addAttribute("updateCnt", deleteCnt);
		
	}
	
	@Override
	public void deleteClientAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	
    // ------------------ 견적서 --------------------------------------------------
	
	// 견적서 등록 
	@Override
	public void estimateResister(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	// 견적서 목록
	@Override
	public void estimateList(HttpServletRequest request, Model model) {
		
		int cnt = 0;// 전체글 개수
		
		cnt = dao.getClientCnt();
		System.out.println("견적서 갯수 cnt : " + cnt);
		
		List<SalesClientDTO> dto = null;
		
		if(cnt > 0) {
			dto = dao.getClientList();
		}
		
		model.addAttribute("dto", dto);
		model.addAttribute("cnt", cnt);
	}

	// 견적서 상세정보
	@Override
	public void estimateDetail(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	// 견적서 수정
	@Override
	public void updateEstimate(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	// 견적서 수정 처리
	@Override
	public void updateEstimateAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	// 견적서 삭제
	@Override
	public void deleteEstimate(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	


	

	
}
