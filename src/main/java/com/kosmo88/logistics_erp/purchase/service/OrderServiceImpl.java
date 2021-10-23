package com.kosmo88.logistics_erp.purchase.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.kosmo88.logistics_erp.purchase.dao.OrderDAO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseInsertOrderDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderDetailViewDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderEstimateListDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderItemDTO;
import com.kosmo88.logistics_erp.purchase.dto.PurchaseOrderListViewDTO;
import com.kosmo88.logistics_erp.util.QueryCode;

@Service
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDAO orderDao;
    
    QueryCode state;
    
    // 구매 관리 - 주문서 목록
	@Override
	public List<PurchaseOrderListViewDTO> orderList(HttpServletRequest req, HttpServletResponse res) {
		return (ArrayList<PurchaseOrderListViewDTO>) orderDao.getOrderList();
	}
	
	// 주문서 상세페이지
	@Override
	public void orderDetail(HttpServletRequest req, Model model) {
		
		// 화면에서 값을 받아온다.
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		// 주문서 상세페이지(거래처, 담당자 정보)
		PurchaseOrderDetailViewDTO dto = orderDao.getOrderDetail(request_id);
		
		// 주문서 상세페이지(상품 정보)
		List<PurchaseOrderDetailViewDTO> idtos = orderDao.getOrderDetailItem(request_id);
		
		model.addAttribute("dto", dto);
		model.addAttribute("idtos", idtos);
	}
	
	// 구매 관리 - 주문서 삭제(선택삭제)
	@Override
	public boolean orderChoiceDelete(int[] request_id) {
		state = QueryCode.UPDATE;
		
		for (int id: request_id) {
			if(!state.check(orderDao.deleteOrder(id))) {
				return false;
			}
		}
		return true;
	}

	// 주문서 삭제(상세페이지에서 단일 삭제)
	@Override
	public void orderDelete(HttpServletRequest req, Model model) {

		// 화면에서 값을 가져온다.
		int id = Integer.parseInt(req.getParameter("request_id"));
		
		state = QueryCode.UPDATE;
		boolean update = false;
		
		// 주문서 삭제 처리
		update = state.check(orderDao.deleteOrder(id));
		logger.info("주문서 삭제 처리 : " + update);
		
		model.addAttribute("update", update);
	}

	// 주문서 등록 화면 - 견적서 선택
	@Override
	public void selectEstimate(HttpServletRequest req, Model model) {
		
		// 주문서 등록 화면 - 견적서 갯수
		int cnt = orderDao.getEstimateCnt();
		logger.info("견적서 갯수 : " + cnt);
		
		// 주문서 등록 화면 - 견적서가 있을때
		if (cnt > 0) {
			// 견적서 리스트
			List<PurchaseOrderEstimateListDTO> dtos = orderDao.getEstimateList();
			
			model.addAttribute("dtos", dtos);
		}
		model.addAttribute("cnt", cnt);
	}

	// 견적서 상품 불러오기
	@Override
	public List<PurchaseOrderItemDTO> orderEstimateItemList(HttpServletRequest req, HttpServletResponse res) {
		
		int request_id = Integer.parseInt(req.getParameter("request_id"));
		
		return (ArrayList<PurchaseOrderItemDTO>) orderDao.getOrderEstimateItemList(request_id);
	}
	
	// 주문서 등록 처리
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean orderRegisterAction(PurchaseInsertOrderDTO dto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean insert = false;
		state = QueryCode.INSERT;
		
		map.put("state", "TX_ORDER");
		map.put("employee_id", dto.getEmployee_id());
		map.put("client_id", dto.getClient_id());
		map.put("end_date", dto.getEnd_date());
		map.put("type", "WITHDRAW");
		map.put("department_id", dto.getDepartment_id());
		logger.info("담당자 id : " + dto.getEmployee_id());
		logger.info("거래처 id : " + dto.getClient_id());
		logger.info("납기요청일자: " + dto.getEnd_date());
		logger.info("담당자 부서 : " + dto.getDepartment_id());
		
		// request tbl 입력
		insert = state.check(orderDao.insertRequest(map));
		logger.info("request tbl 입력 : " + insert);
		
		// slip tbl 입력
		insert = state.check(orderDao.insertSlip(map));
		logger.info("slip tbl 입력 : " + insert);
		
		return insert;
	}
	
	// 주문서 상품 등록 처리
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean itemRegisterAction(PurchaseOrderItemDTO dto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean insert = false;
		state = QueryCode.INSERT;
		
		map.put("quantity", dto.getItem_quantity());
		map.put("item_id", dto.getItem_id());
		logger.info("상품 수량 : " + dto.getItem_quantity());
		logger.info("상품 코드 : " + dto.getItem_id());
		
		// product_group tbl 입력
		insert = state.check(orderDao.insertProductGroup(map));
		logger.info("product_group tbl 입력 : " + insert);
		
		// req_product_list tbl 입력
		insert = state.check(orderDao.insertRPL());
		logger.info("req_product_list tbl 입력 : " + insert);
		
		return insert;
	}

	// 주문 승인 요청
	@Override
	public boolean orderApproval(int id) {
		
		// 안드로이드 디바이스 토큰
		String send = "fWdd9-ylRr24WYMm34VZf7:APA91bHH5aL7dvzwKM2WNttpRgKtK1sxwQOPowfhj-fHzaidivMdvnZsdXYPvJe-m7Zdcy_2GzpM7qo9Q2wcndclxnMBZYO1dw_5sSKvStlh0ycMce4vrhGa4v8IfBNeU_p3vp91Pgoc";
		String company = "KU ERP Kosmo Ultimate ERP";
		String account_send = "구매팀에서 주문서 승인을 요청하였습니다.";
		
		state = QueryCode.UPDATE;
		boolean approval = state.check(orderDao.requestApproval(id));
		
		if (approval) {
			ApprovalRequestAlert(send, company, account_send);
		}
		
		return approval;
	}
	
	// FCM 발송
	public void ApprovalRequestAlert(String tokenId, String title, String content) {
		// 메세지 성공여부
        try {    
            // json 파일 경로 입력
            FileInputStream refreshToken = new FileInputStream("D:\\Dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\purchase\\json\\kosmo88erp-38a3c-firebase-adminsdk-927z7-f61b2ca066.json");
            
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com")
                    .build();
            
            //Firebase 처음 호출시에만 initializing 처리
            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            //String requestToken = 안드로이드 토큰 입력;
            String requestToken = tokenId;

            //message 작성
            Message msg = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000) // 1 hour in milliseconds
                        .setPriority(AndroidConfig.Priority.NORMAL)
                        .setNotification(AndroidNotification.builder()
                            .setTitle(title)
                            .setBody(content)
                            .setIcon("stock_ticker_update")
                            .setColor("#f45342")
                            .build())
                        .build())
                    .setToken(requestToken)
                    .build();

            // 메세지를 FirebaseMessaging에 보내기
            String response = FirebaseMessaging.getInstance().send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
	}
}
