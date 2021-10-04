package com.kosmo88.logistics_erp.sale.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.sale.dao.SalesClientDAO;
import com.kosmo88.logistics_erp.sale.dto.SalesClientDTO;
//import com.kosmo88.logistics_erp.sale.dto.SalesInsertClientDTO;
import com.kosmo88.logistics_erp.sale.dto.SalesItemDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class SalesClientServiceImpl implements SalesClientService{

	@Autowired
	SalesClientDAO clientDao;
	
	QueryCode state;

	// 거래처 목록
	@Override
	public List<SalesClientDTO> clientList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<SalesClientDTO>) clientDao.getClientList();
	}

	// 거래처 등록 처리
//	@Override
//	public boolean clientRegisterAction(SalesInsertClientDTO dto) {
//		state = QueryCode.INSERT;
//		
//		dto.setEmail(dto.getEmail1() + "@" + dto.getEmail2());
//		dto.setPhone(dto.getPhone1() + "-" + dto.getPhone2() + "-" + dto.getPhone3());
//		dto.setRegister_num(dto.getRegister_num1() + "-" + dto.getRegister_num2() + "-" + dto.getRegister_num3());
//		dto.setType("판매");
//		dto.setEnabled("Y");
//		
//		return state.check(clientDao.registerClient(dto));
//	}

	// 아이템 등록 처리
	@Override
	public boolean itemRegisterAction(SalesItemDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	// 거래처 상세 페이지
	@Override
	public void clientDetail(HttpServletRequest req, Model model) {

		// 화면에서 값 가져온다.
		int id = Integer.parseInt(req.getParameter("id"));	// 거래처코드
		
		// 상세페이지 - 거래처 목록
		SalesClientDTO cdto = clientDao.getClientDetail(id);
		
		model.addAttribute("cdto", cdto);
	}

	// 거래처 삭제(선택 삭제)
	@Override
	public boolean clientChoiceDelete(int[] client_id) {
		state = QueryCode.UPDATE;
		
		for(int i : client_id) {
			if (!state.check(clientDao.deleteClient(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clientUpdate(HttpServletRequest req, Model model) {
		int id = Integer.parseInt(req.getParameter("client_id"));
		
		SalesClientDTO cdto = clientDao.getClientDetail(id);
		
		model.addAttribute("cdto", cdto);
	}

	@Override
	public void clientUpdateAction(HttpServletRequest req, Model model) {
		
		SalesClientDTO cdto = new SalesClientDTO();
		
		// 화면에서 값을 불러온다.
		int client_id = Integer.parseInt(req.getParameter("id"));	// 거래처 번호
		
		// 대표자명
		String ceo_name = req.getParameter("ceo_name");
		
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		
		// 거래처 연락처
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		
		// 거래처 이메일
		String email = req.getParameter("email");			
		
		String register_num1 = req.getParameter("register_num1");
		String register_num2 = req.getParameter("register_num2");
		String register_num3 = req.getParameter("register_num3");
		
		// 사업자 번호
		String register_num = register_num1 + "-" + register_num2 + "-" + register_num3;
		
		// 우편번호
		int zip_code = Integer.parseInt(req.getParameter("zip_code"));
		
		// 주소
		String address = req.getParameter("address");
		
		// 상세주소
		String detail_address = req.getParameter("detail_address");
		
		cdto.setId(client_id);
		cdto.setCeo_name(ceo_name);
		cdto.setRegister_num(register_num);
		cdto.setAddress(address);
		cdto.setDetail_address(detail_address);
		cdto.setZip_code(zip_code);
		cdto.setPhone(phone);
		cdto.setEmail(email);
		//cdto.setEnabled("Y");
		
		state = QueryCode.UPDATE;
		boolean update;
		
		// 거래처 등록 처리
		update = state.check(clientDao.updateClient(cdto));
		System.out.println("거래처 수정 처리 : " + update);
		
		model.addAttribute("update", update);
		
	}

	@Override
	public void clientDelete(HttpServletRequest req, Model model) {

		int id = Integer.parseInt(req.getParameter("client_id"));  // 거래처코드
		System.out.println("id" + id);
		state = QueryCode.UPDATE;
		boolean update = false;
		
		// 거래처 삭제 처리
		update = state.check(clientDao.deleteClient(id));
		System.out.println("거래처 삭제 처리 : " + update);
		
		model.addAttribute("update", update);
		
	}
	
	

}
