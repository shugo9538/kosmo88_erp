package com.kosmo88.logistics_erp.purchase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kosmo88.logistics_erp.purchase.dao.PurchaseDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseClientDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseItemDTO;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseDAO purchaseDao;
    
    // 거래처(구매처) 관리 - 거래처 목록
	@Override
	public void clientList(HttpServletRequest req, Model model) {

		// 거래처 갯수
		int cnt = 0;
		
		// 거래처 목록
		List<PurchaseClientDTO> dtos = null;
		
		// 거래처 갯수 가져오기
		cnt = purchaseDao.getClientCnt();
		System.out.println("거래처 갯수 : " + cnt);
		
		// 등록된 거래처가 있으면
		if (cnt > 0) {
			dtos = purchaseDao.getClientList();
		}
		
		// jsp로 전달
		model.addAttribute("cnt", cnt);
		model.addAttribute("dtos", dtos);
	}
    
    // 거래처, 상품등록 처리 
	@Override
	public void RegisterClient(HttpServletRequest req, Model model) {
		
		// 거래처 바구니
		PurchaseClientDTO cdto = null;
		
		// 화면 입력 값 받아오기
		
		// 거래처명
		String name = req.getParameter("name");
		// 대표자명
		String ceo_name = req.getParameter("ceo_name");
		
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		
		// 거래처 연락처
		String phone = phone1 + phone2 + phone3;
		
		// 거래처 이메일
		String email = req.getParameter("email");			
		
		String register_num1 = req.getParameter("register_num1");
		String register_num2 = req.getParameter("register_num2");
		String register_num3 = req.getParameter("register_num3");
		
		// 사업자 번호
		long register_num = Long.parseLong(register_num1 + register_num2 + register_num3);
		
		// 우편번호
		int zip_code = Integer.parseInt(req.getParameter("zip_code"));
		
		// 주소
		String address = req.getParameter("address");
		
		// 상세주소
		String detail_address = req.getParameter("detail_address");
		
		cdto.setName(name);
		cdto.setCeo_name(ceo_name);
		cdto.setRegister_num(register_num);
		cdto.setAddress(address);
		cdto.setDetail_address(detail_address);
		cdto.setZip_code(zip_code);
		cdto.setPhone(phone);
		cdto.setEmail(email);
		
		// 상품명, 상품종류, 상품가격
		String[] item_names = req.getParameterValues("item_name");
		String[] categorys = req.getParameterValues("category");
		String[] prices = req.getParameterValues("price");
		
		// 거래처 등록 처리
		// boolean SUCCESS_CODE = purchaseDao.RegisterClient(cdto);
		int clientCnt = purchaseDao.RegisterClient(cdto);
		// System.out.println("거래처 등록 처리 : " + SUCCESS_CODE);
		System.out.println("거래처 등록 처리 : " + clientCnt);
		
		// if (SUCCESS_CODE) {
				
		// }
		
		PurchaseItemDTO idto = null; 
		String item_name = "";
		String category = "";
		int itemCnt = 0;
		int price = 0;
		
		// 거래처 등록 되었으면
		if (clientCnt == 1) {
			for(int i = 0; i < item_names.length; i++) {
				
				item_name = item_names[i];
				category = categorys[i];
				price = Integer.parseInt(prices[i]);
				
				idto.setItem_name(item_name);
				idto.setCategory(category);
				idto.setPrice(price);
				
				// 상품 등록 처리
				itemCnt = purchaseDao.RegisterItem(idto);
				System.out.println("상품 등록 처리 : " + itemCnt);
			}
		}
		
		model.addAttribute("clientCnt", clientCnt);
		model.addAttribute("itemCnt", itemCnt);
	}

}
