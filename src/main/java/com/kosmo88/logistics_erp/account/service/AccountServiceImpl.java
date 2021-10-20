package com.kosmo88.logistics_erp.account.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.kosmo88.logistics_erp.account.code.MenuCode;
import com.kosmo88.logistics_erp.account.dao.AccountDAO;
import com.kosmo88.logistics_erp.account.dto.AccountDTO;
import com.kosmo88.logistics_erp.account.dto.BalanceDTO;
import com.kosmo88.logistics_erp.account.dto.ClientDTO;
import com.kosmo88.logistics_erp.account.dto.AccountHistoryDTO;
import com.kosmo88.logistics_erp.account.dto.FinancialStatementsDTO;
import com.kosmo88.logistics_erp.account.dto.IncomeStatementDTO;
import com.kosmo88.logistics_erp.account.dto.SalesSlipDTO;
import com.kosmo88.logistics_erp.account.dto.SlipDTO;
import com.kosmo88.logistics_erp.account.utilTest.FcmUtil;
import com.kosmo88.logistics_erp.account.utilTest.FirebasePushMessage;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDAO accountDAO;
	MenuCode menuCode;
	FcmUtil fcm ;
	
	// ------------------------------ 기초정보관리 ------------------------------
	// 기초정보 관리 - 거래처 목록(ajax) clientList.jsp
	@Override
	public void clientList(Model model) {
		
		List<ClientDTO> client = new ArrayList<ClientDTO>();
		int cnt = 0;
		cnt = accountDAO.getClientCnt();
		
		client = accountDAO.selectClient();
		System.out.println("기초정보관리 - 거리처목록 : " + client);
		
		model.addAttribute("client", client);
		model.addAttribute("cnt", cnt);
	
	}
	// 거래처 등록
	@Override
	public void clientInsertAction(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}
	// ------------------------------ 일반전표 ------------------------------
	// 일반전표 - 일반전표(ajax) slipList.jsp
	@Override
	public void slipList(Model model) {

		List<SlipDTO> slip = new ArrayList<SlipDTO>();

		slip = accountDAO.selectSlipList();
		System.out.println("일반전표관리 - 일반전표 : " + slip.size());
		System.out.println("전표 : " + slip);
		
		model.addAttribute("slip", slip);
	
	}
	// 일반전표 - 수정처리
	@Override
	public void slipModifyDetail(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		System.out.println("일반전표 수정페이지 아이디  : " + id);
		
		SlipDTO slip = new SlipDTO();
			System.out.println("통과");
			//slip = accountDAO.selectSlip(id);
		
		System.out.println("일반전표관리 - 일반전표수정 : " + slip);
		
		model.addAttribute("slip", slip);
		
	}
	// 일반전표 - 회계팀 지출결의
	@Override
	public void slipInsertAction(HttpServletRequest request, Model model) {
		int insertCnt = 0;
		SlipDTO slipDTO = new SlipDTO();
		
		// request_tbl
		String state = request.getParameter("state");
		String employee_id = request.getParameter("employee_id");
		int client_id = Integer.parseInt(request.getParameter("client_id"));
		
		System.out.println("state : " + state);
		System.out.println("employee_id : " + employee_id);
		System.out.println("client_id : " + client_id);
		
		slipDTO.setState(state);
		slipDTO.setEmployee_id(employee_id);
		slipDTO.setClient_id(client_id);
			
		if (employee_id != null) {
				insertCnt = accountDAO.insertRequest(slipDTO);
				System.out.println("회계팀 부서요청 정보 : " + slipDTO);
				System.out.println("===== 부서요청 insertCnt : " + insertCnt);
			
				if(insertCnt == 1) {
					// operating_expense_tbl
					String account_title = request.getParameter("account_title");
					String abs = request.getParameter("abs");
					int expenses =  Integer.parseInt(request.getParameter("expenses"));
					
					System.out.println("account_title : " + account_title);
					System.out.println("abs : " + abs);
					System.out.println("expenses : " + expenses);
					
					slipDTO.setAccount_title(account_title);
					slipDTO.setAbs(abs);
					slipDTO.setExpenses(expenses);
					
					insertCnt = accountDAO.insertOperating_expense(slipDTO);
					System.out.println("회계팀 비용요청 정보 : " + slipDTO);
					System.out.println("===== 비용요청 insertCnt : " + insertCnt);
					
					if(insertCnt == 1) {
						// slip_tbl
						String type = request.getParameter("type");
						int department_id =  Integer.parseInt(request.getParameter("department_id"));
						System.out.println("type : " + type);
						System.out.println("department_id : " + department_id);
						
						slipDTO.setType(type);
						slipDTO.setDepartment_id(department_id);
						
						insertCnt = accountDAO.insertSlip(slipDTO);
						System.out.println("회계팀 일반전표 정보 : " + slipDTO);
						System.out.println("===== 회계팀 전표요청 insertCnt : " + insertCnt);
						
						if(insertCnt == 1) {
							model.addAttribute("SUCCESS", MenuCode.SUCCESS);
							System.out.println("회계팀 지출결의서 등록 성공 ");
						}else {
							model.addAttribute("FAIL", MenuCode.FAIL);
							System.out.println("회계팀 지출결의서 등록 실패 ");
						}
						
					}else {
						model.addAttribute("EXPENSE", MenuCode.EXPENSE);
						System.out.println("회계팀 지출결의 operating_expense_tbl 실패");
					}
				}else{
					model.addAttribute("REQUEST_CODE_FAIL", MenuCode.REQUEST_CODE_FAIL);
					System.out.println("회계팀 지출결의 requet_tbl 실패");
				}
		}else{
			model.addAttribute("EMPLOYEE_ID", MenuCode.EMPLOYEE_ID);
			System.out.println("회계팀 지출결의 사원번호가 확인");
			}
		
		
	}
	// 일반전표 - 부서별 일반전표 승인처리
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void slipConfirmAction(HttpServletRequest request, Model model) {
		
		// slipList.jsp 에서 화면에서 선택된 전표 번호
		String[] slipid_chk =   request.getParameterValues("slipid_chk");
			System.out.println("slipid_chk : " + slipid_chk);
			
			// chk박스 전표아이디를 돌린다.
			List<SlipDTO> slipList = new ArrayList<SlipDTO>();
			for (int i = 0; i < slipid_chk.length; i++) {
				SlipDTO dto = new SlipDTO();
				
				dto = accountDAO.selectSlip(Integer.parseInt(slipid_chk[i]));
				
				slipList.add(dto);
				System.out.println("slipList.size() : " + slipList.size());
			}
			
			System.out.println("slipList 값 : " + slipList);
			
			
			// 리스트로 담아놓은 slipDTO 다시 꺼내자
			for (int i = 0; i < slipList.size(); i++) {
				SlipDTO dto = new SlipDTO();
				Map<String, Object> map = new HashMap<String, Object>();
				
				dto = slipList.get(i);
				
				int dpart_id = dto.getDepartment_id(); // 일반전표tbl부서코드
				int slip_id = dto.getId();			   // 일반전표tbl아이디
				String state = dto.getState();		   // 일반전표tbl상태
				int dpart_req = dto.getDepartment_request(); // request_tbl 아이디
				
				String type = dto.getType();
				
				System.out.println(" slip_id : " + slip_id);
				System.out.println(" dpart_id : " + dpart_id);
				System.out.println(" state : " + state);
				System.out.println(" dpart_req : " + dpart_req);
				System.out.println(" type : " + type);
				
				//회계팀 일반전표 기준
				/*
				 * 1. 전표상태 N 일때   
				 * 2. 부서코드 확인 ( 인사100, 회계 200, 영업 300, 구매 400, 물류 500)
				 * 3. 전표유형  영업 : DEPOSIT 구매 : WITHDRAW 일반 : GENERAL 확인
				 * 4. 
				 * 5. 최종승인시 승일자 UPDATE 초기 DEFAULT NULL
				*/
				
				// 일반전표 승인상태 'N' 일때 들어온다.
				if (state.equals("N")) {
					int updateCnt = 0;
					
						System.out.println("===");
						System.out.println("state : " + state);
						System.out.println("dpart_id : " + dpart_id);
						System.out.println("===");
						
						// 부서코드는 0 이상으로 각 부서별 코드번호는 ( 인사100, 회계 200, 영업 300, 구매 400, 물류 500 )
						if (dpart_id > 0) {
							map.put("slip_id", slip_id);
							map.put("dpart_req", dpart_req);
							
							map.put("dpart_id", dpart_id);
							map.put("state", state);
							map.put("type", type);
							
							// 각 부서코드가 들어올때 각 부서별 코드번호로 각 항목으로 들어간다.
							switch(dpart_id) {
							// 인사팀
							case MenuCode.HR:
								map.put("new_state",MenuCode.HR_STATE);
								updateCnt = accountDAO.updateSlipState(map);
								System.out.println("인사팀 전표 승인: " + updateCnt);
								
								if (updateCnt == 1) {
									updateCnt = accountDAO.updateRequestState(map);
									System.out.println("인사팀 updateCnt : " + updateCnt);
									
									switch(updateCnt) {
									case 1:
										slipConfirmAlert(MenuCode.SEND,MenuCode.COMPANY,MenuCode.ACCOUNT_SEND);
										model.addAttribute("SUCCESS", MenuCode.SUCCESS);
										System.out.println("인사팀 전표승인 완료");
										break;
										default:
											model.addAttribute("FAIL", MenuCode.FAIL);
											System.out.println("인사팀 REQUEST_TBL UPDATE 실패");
											break;
									}
									System.out.println("인사팀입니다.");
								}else {
									model.addAttribute("FAIL", MenuCode.FAIL);
									System.out.println("인사팀 일반전표 업데이트 실패하였습니다.");
								}
								break;
							// 구매팀	
							case MenuCode.PURCHASE:
								map.put("new_state", MenuCode.PURCHASE_STATE);
								updateCnt = accountDAO.updateSlipState(map);
								System.out.println("구매팀 전표 승인: " + updateCnt);
								
								if(updateCnt == 1) {
									updateCnt = accountDAO.updateRequestState(map);
									System.out.println("구매팀 updateCnt : " + updateCnt);
									System.out.println("구매팀 전표 승인 : " + updateCnt);
									System.out.println("==========================");
									
									updateCnt = accountDAO.insertPurchaseSlip(map);
									System.out.println("구매팀 매출전표 발행 : " + updateCnt);
										
									if (updateCnt > 0) {	// 다건일 경우 updateCnt 1이상의 결과가 insertPurchaseSlip 에서 발생
											slipConfirmAlert(MenuCode.SEND,MenuCode.COMPANY,MenuCode.PURCHASE_SEND);
											
											model.addAttribute("SUCCESS", MenuCode.SUCCESS);
											System.out.println("구매팀 전표승인 완료");
									}else {
											model.addAttribute("SLIP_CREATE_FAIL", MenuCode.SLIP_CREATE_FAIL);
											System.out.println("구매팀 SALES_LIP_TBL 실패");
									}
									System.out.println("구매팀입니다.");
									
								}else {
									model.addAttribute("FAIL", MenuCode.FAIL);
									System.out.println("구매팀 일반전표 업데이트 실패하였습니다.");
								}
								break;
							// 영업팀	
							case MenuCode.SALE:
								map.put("new_state", MenuCode.SALES_STATE);
								updateCnt = accountDAO.updateSlipState(map);
								System.out.println("영업팀 전표 승인 : " + updateCnt);
								System.out.println("==========================");
								
								updateCnt = accountDAO.insertSalesSlip(map);
								System.out.println("영업팀 매출전표 발행 : " + updateCnt);
								
								if (updateCnt == 1) {
									updateCnt = accountDAO.updateRequestState(map);
									System.out.println("영업팀 updateCnt : " + updateCnt);
									
									switch(updateCnt) {
									case 1:
										// 전표승인 push 알람 발송
										slipConfirmAlert(MenuCode.SEND,MenuCode.COMPANY,MenuCode.SALES_SEND);
										
										model.addAttribute("SUCCESS", MenuCode.SUCCESS);
										System.out.println("영업팀 전표승인 완료");
										break;
									default:
										model.addAttribute("SLIP_CREATE_FAIL", MenuCode.SLIP_CREATE_FAIL);
										System.out.println("영업팀 SALES_LIP_TBL 실패");
										break;
									}
									System.out.println("영업팀입니다.");
								}else {
									model.addAttribute("FAIL", MenuCode.FAIL);
									System.out.println("영업팀 일반전표 업데이트 실패하였습니다.");
								}
								break;
							// 물류팀	
							case MenuCode.WMS:
								map.put("new_state",MenuCode.WMS_STATE);
								updateCnt = accountDAO.updateSlipState(map);
								System.out.println("물류팀 전표 승인: " + updateCnt);
								
								if(updateCnt == 1) {
									updateCnt = accountDAO.updateRequestState(map);
									System.out.println("물류팀 updateCnt : " + updateCnt);
									
									switch(updateCnt) {
									case 1:
										model.addAttribute("SUCCESS", MenuCode.SUCCESS);
										System.out.println("물류팀 전표승인 완료");
										break;
									default:
										model.addAttribute("FAIL", MenuCode.FAIL);
										System.out.println("물류팀 REQUEST_TBL UPDATE 실패");
										break;
									}
									System.out.println("물류팀입니다.");
								}else {
									model.addAttribute("FAIL", MenuCode.FAIL);
									System.out.println("물류팀 일반전표 업데이트 실패하였습니다.");
								}
								break;
							// 회계팀
							case MenuCode.ACCOUNT:
								map.put("new_state",MenuCode.ACCOUN_STATE);
								updateCnt = accountDAO.updateSlipState(map);
								
								System.out.println("회계팀 전표 승인: " + updateCnt);
								
								if(updateCnt == 1) {
									updateCnt = accountDAO.updateRequestState(map);
									System.out.println("회계팀");
									
									switch(updateCnt) {
									case 1:
								    	slipConfirmAlert(MenuCode.SEND, MenuCode.COMPANY, MenuCode.ACCOUNT_SEND);
										model.addAttribute("SUCCESS", MenuCode.SUCCESS);
										System.out.println("회계팀 전표승인 완료");
										break;
									default:
										model.addAttribute("FAIL", MenuCode.FAIL);
										System.out.println("회계팀 REQUEST_TBL UPDATE 실패");
										break;
									}
									System.out.println("회계팀입니다.");
								}else {
									model.addAttribute("FAIL", MenuCode.FAIL);
									System.out.println("회계팀 일반전표 업데이트 실패하였습니다.");
								}
								break;
								// 부서번호가 없을경우
								default:
									model.addAttribute("UNIDENTIFIED", MenuCode.UNIDENTIFIED);
									System.out.println(" 없는 부서 번호 입니다. 다시 확인 바랍니다.");
								break;
							}
						}else {
							System.out.println(" 부서코드가 올바르지 않습니다. 다시 확인 바랍니다.");
							model.addAttribute("UNIDENTIFIED", MenuCode.UNIDENTIFIED);
						}
				}else {
					System.out.println("승인상태가 '미승인'이 아닙니다.");
					model.addAttribute("NOT_APPROVED", MenuCode.NOT_APPROVED);
				}
			}
	}
	
	
	
	// FCM 발송
	@Override
	public void slipConfirmAlert(String tokenId, String title, String content)   {
		 //  메세지 성공여부
	        try {    
	            // json 파일 경로 입력
	            FileInputStream refreshToken = new FileInputStream("C:\\dev88\\workspace\\kosmo88_erp\\src\\main\\webapp\\resources\\account\\json\\kosmo88erp-38a3c-firebase-adminsdk-927z7-f61b2ca066.json");
	            
	            FirebaseOptions options = new FirebaseOptions.Builder()
	                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
	                    .setDatabaseUrl("https://kosmo88erp-38a3c.firebaseio.com")
	                    .build();
	            
	            //Firebase 처음 호출시에만 initializing 처리
	            if(FirebaseApp.getApps().isEmpty()) { 
	                FirebaseApp.initializeApp(options);
	            }
	            //String registrationToken = 안드로이드 토큰 입력;
	            String registrationToken = tokenId;

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
	                    .setToken(registrationToken)
	                    .build();

	            // 메세지를 FirebaseMessaging에 보내기
	            String response = FirebaseMessaging.getInstance().send(msg);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	 }
		 
	// 일반전표 세부내역
	@Override
	public void slipDetailInfo(HttpServletRequest request, Model model) {

		int id = Integer.parseInt(request.getParameter("slip_id"));
		System.out.println("전표 번호 : " + id);

		SlipDTO slipDTO = new SlipDTO();
		System.out.println("일반전표 세부내역");
		
		slipDTO = accountDAO.selectSlip(id);
		
		if (slipDTO != null) {
			
			Map<String, Object> slipmap = new HashMap<String, Object>();
			
			int slip_id = slipDTO.getId();
			String type = slipDTO.getType();
			int dept_req = slipDTO.getDepartment_request();
			int dept_id = slipDTO.getDepartment_id();
			String state = slipDTO.getState();
			
			slipmap.put("slip_id" , slip_id);
			slipmap.put("type" , type);
			slipmap.put("dept_req" , dept_req);
			slipmap.put("dept_id" , dept_id);
			slipmap.put("state" , state);
			
			System.out.println("slip_id : " + slip_id + "type : " + type + "dept_req : " + dept_req + "dept_id : " + dept_id + "state : " + state); 
			
			List<SlipDTO> slipList = new ArrayList<SlipDTO>();
			SlipDTO slip = null;
			if (type.equals("GENERAL")) {
				
				System.out.println("일반전표 : ");
				switch(dept_id) {
				case MenuCode.HR:
					System.out.println("인사 부서코드 : " + dept_id);
					
					slipList = accountDAO.selectSlipInfo(slipmap);
					System.out.println("slipList :" + slipList);
					model.addAttribute("slipList", slipList);
					model.addAttribute("dept_id",dept_id);
					/*
					if (slipList != null) {
						model.addAttribute("slipList", slipList);
						System.out.println("==================");
						System.out.println("=======인 사 팀======");
						slip = new ArrayList<SlipDTO>();

						slip = accountDAO.selectOrdrDetail(slipmap);

						model.addAttribute("slip", slip);
						model.addAttribute("dept_id",dept_id);
						System.out.println("=====" + slip.size());
						System.out.println("인사팀 전표 조회를 완료 하였습니다.");
					}
					*/
					break;
				case MenuCode.ACCOUNT:
					System.out.println("회계 부서코드 : " + dept_id);
					
					slip = accountDAO.selectOrdrDetail(slipmap);
					System.out.println("slip :" + slip);
					System.out.println("==================");
					System.out.println("=======회 계 팀======");
					
					model.addAttribute("dto", slip);
					model.addAttribute("dept_id",dept_id);
					break;
				case MenuCode.WMS:
					System.out.println("물류 부서코드 : " + dept_id);
					
					break;
				case MenuCode.PURCHASE:
					System.out.println("구매 부서코드 : " + dept_id);
					
					break;
					
				case MenuCode.SALE:
					System.out.println("영업 부서코드 : " + dept_id);
					
					break;
				default:
					
					break;
				}

			} else if (type.equals("DEPOSIT") || type.equals("WITHDRAW")) {
				System.out.println("매입/매출전표 : ");
				switch(dept_id) {
				case MenuCode.HR:
					System.out.println("인사 부서코드 : " + dept_id);
					break;
				case MenuCode.ACCOUNT:
					System.out.println("회계 부서코드 : " + dept_id);
					break;
				case MenuCode.WMS:
					System.out.println("물류 부서코드 : " + dept_id);
					break;
				case MenuCode.PURCHASE:
					System.out.println("구매 부서코드 : " + dept_id);
					
					slipList = accountDAO.selectSlipInfo(slipmap);
					
					if (slipList != null) {
						model.addAttribute("slipList", slipList);
						System.out.println("==================");
						System.out.println("=======구 매 팀======");
						slip = new SlipDTO();

						slip = accountDAO.selectOrdrDetail(slipmap);

						model.addAttribute("slip", slip);
						model.addAttribute("dept_id",dept_id);
						
						model.addAttribute("dto", slip);
						model.addAttribute("dept_id",dept_id);
						System.out.println("구매팀 전표 조회를 완료 하였습니다.");

					}else {
						System.out.println("구매팀 전표정보 조회에 실패 하였습니다.");
					}
					break;
				case MenuCode.SALE:
					System.out.println("영업 부서코드 : " + dept_id);
					slipList = accountDAO.selectSlipInfo(slipmap);
					
					if (slipList != null) {
						model.addAttribute("slipList", slipList);
						System.out.println("==================");
						System.out.println("=======영 업 팀======");
						slip = new SlipDTO();

						slip = accountDAO.selectOrdrDetail(slipmap);
						System.out.println("영업팀 slip : " + slip);
						

						model.addAttribute("dto", slip);
						model.addAttribute("dept_id",dept_id);
						System.out.println("영업팀 전표 조회를 완료 하였습니다.");

					}else {
						System.out.println("영업팀 전표정보 조회에 실패 하였습니다.");
					}
					break;
				}
			}else{
				System.out.println("요청하신 전표 유형이 없습니다. 다시 확인 바랍니다.");
			}
		}else {
			System.out.println("요청하신 전표가 없습니다. 다시 확인 바랍니다.");
		}
	}

	// ------------------------------ 매입/매출장 ------------------------------
		// 매입/매출장 - 메인(ajax) salesSlipList.jsp
		@Override
		public void salesSlipList(Model model) {
			List<SalesSlipDTO> saleslip = new ArrayList<SalesSlipDTO>();
			SalesSlipDTO sum = new SalesSlipDTO();
			
			saleslip = accountDAO.selectSalesSlip();
			System.out.println("매입/매출장 목록 : " + saleslip);
			
			model.addAttribute("saleslip", saleslip);
			
			sum = accountDAO.selectSalesSlipSum();
			
			model.addAttribute("sum", sum);
			System.out.println("공급가액, 세액 , 합계 : " + sum);
			
			//String type = "";
			int getCnt = 0;
			getCnt = accountDAO.getSalesSlipCnt();
			model.addAttribute("getCnt", getCnt);
			
			System.out.println("getCnt : " + getCnt);
			
		}
		// 매입 전표 조회
		@Override
		public void purchaseList(Model model) {
			List<SalesSlipDTO> saleslip = new ArrayList<SalesSlipDTO>();
			SalesSlipDTO sum = new SalesSlipDTO();
			
			saleslip = accountDAO.selectPurchaseList();
			System.out.println("매입전표 조회 : " + saleslip);
			
			//String type = "WITHDRAW";
			int getCnt = 0;
			getCnt = accountDAO.getPurchaseeCnt();
			
			sum = accountDAO.selectPurchaseeSum();
			
			model.addAttribute("sum", sum);
			System.out.println("공급가액, 세액 , 합계 : " + sum);
			
			model.addAttribute("getCnt", getCnt);
			model.addAttribute("saleslip", saleslip);
		}
		// 매출 전표 조회
		@Override
		public void salesList(Model model) {
			List<SalesSlipDTO> saleslip = new ArrayList<SalesSlipDTO>();
			SalesSlipDTO sum = new SalesSlipDTO();
			
			saleslip = accountDAO.selectSalesList();
			System.out.println("매출전표 조회 : " + saleslip);
			
			//String type = "DEPOSIT";
			int getCnt = 0;
			getCnt = accountDAO.getSalesCnt();
			
			sum = accountDAO.selectSalesSum();
			
			model.addAttribute("sum", sum);
			System.out.println("공급가액, 세액 , 합계 : " + sum);
			
			model.addAttribute("getCnt", getCnt);
			model.addAttribute("saleslip", saleslip);
		}
	
	// ------------------------------ 금융/자금관리 ------------------------------
	// 보유통장 - 전체목록(ajax) accountList.jsp 
	@Override
	public void accountList(HttpServletRequest req, Model model) {
		
		List<AccountDTO> account = new ArrayList<AccountDTO>();
		
		account = accountDAO.selectAccount();
		System.out.println("금융/자금관리 - 통장목록: " + account);
		
		model.addAttribute("account", account);
		
	}
	// 통장 계좌번호 검사
	@Override
	public void accountNumberCheck(HttpServletRequest request, Model model) {
		
		String account_number = request.getParameter("account_number");
		
		System.out.println("서비스 계좌번호 : " + account_number);
		
		int selectCnt = 0;
		selectCnt = accountDAO.accountNumberCheck(account_number);
		
		model.addAttribute("account_number", account_number);
		model.addAttribute("selectCnt", selectCnt);
		
		System.out.println("selectCnt : " + selectCnt);
	
	}
	// 통장정보 미사용 처리
	@Override
	public void accountEnabledAction(HttpServletRequest request, Model model) {

		String account_number = request.getParameter("account_number");
		
		System.out.println("account_number" + account_number);
		int updateCnt = 0;
		
		updateCnt = accountDAO.updateAccountEnabled(account_number);
		
		model.addAttribute("updateCnt", updateCnt);
		
	}
	// 신규통장 추가 처리
	@Override
	public void accountInsertAction(HttpServletRequest request, Model model) {
		
		// accountNewDetail.jsp에서 입력받은 값 
		
		int account_holder_id = Integer.parseUnsignedInt(request.getParameter("account_holder_id")); // 관계테이블 FK
		String name = request.getParameter("name"); // 계좌명
		String account_number = request.getParameter("account_number"); // 계좌번호
		String bank = request.getParameter("bank"); // 계좌은행
		int balance = Integer.parseInt(request.getParameter("balance")); // 기초잔액
		
		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_holder_id(account_holder_id);
		accountDTO.setName(name);
		accountDTO.setAccount_number(account_number);
		accountDTO.setBank(bank);
		accountDTO.setBalance(balance);
		accountDTO.setRegister(new Date(System.currentTimeMillis()));
		
		int insertCnt = 0;
		insertCnt = accountDAO.insertAccount(accountDTO);
		System.out.println("accountDTO : " + accountDTO);
		
		if (insertCnt > 0) {
			model.addAttribute("insertCnt", insertCnt);
			System.out.println("insertCnt 성공 : " + insertCnt );
		}else {
			model.addAttribute("insertCnt", insertCnt);
			System.out.println("insertCnt 실패 : " + insertCnt );
		}
		
	}
	// 통장 거래내역 추가 단건 추가 처리 페이지(통장정보조회)
	@Override
	public void accountSimplDetail(HttpServletRequest request, Model model) {
		
		List<AccountDTO> account = new ArrayList<AccountDTO>(); 
		
		account = accountDAO.selectAccount();
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
		//String transaction_time = request.getParameter("transaction_time"); // 거래시간
		
		if (type.equals("출금")) {
			balance = - + balance;			
		}
		
		// 날짜
		String t_date = transaction_date.substring(2);
		System.out.println("t_date : " + t_date); //앞 2자리 지우기
		
		int insertCnt = 0;
		if (account_number != null) {
			
			ahDTO.setAccount_number(account_number);
			ahDTO.setType(type);
			ahDTO.setBalance(balance);
			ahDTO.setAbs(abs);
			ahDTO.setTransaction_date(t_date);
			
			insertCnt = accountDAO.insertAcountHistory(ahDTO);
			
			model.addAttribute("insertCnt", insertCnt);
			System.out.println("통장 거래내역 추가 : " + insertCnt);
			
			if (insertCnt == 1) {
				insertCnt = accountDAO.updateAccountBalance(account_number);
				model.addAttribute("insertCnt", insertCnt);
				System.out.println("통장 잔액 업데이트 : " + insertCnt);
			}else {
				insertCnt = 2;
				model.addAttribute("insertCnt", insertCnt);
				System.out.println("통장 잔액업데이트 실패 : " + insertCnt);
			}
		}else {
			model.addAttribute("insertCnt", insertCnt);
			System.out.println("계좌번호가 확인 되지 않습니다. 다시 확인 바랍니다. " + insertCnt);
		}
	}

	// 통장 입출금내역조회
	@Override
	public void accountTransactionHistory(HttpServletRequest request, Model model) {
		
		//accountList.jsp 에서 전달받은 값
		String account_number = request.getParameter("account_number");
		System.out.println("통장 입출금내역1 : " + account_number);
		
		List<BalanceDTO> balanceDTO = new ArrayList<BalanceDTO>();
		
		balanceDTO = accountDAO.selectAccountBalance(account_number); 

		model.addAttribute("dtos", balanceDTO);
		System.out.println("잔액조회 balanceDTO : " + balanceDTO);
		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO = accountDAO.selectAccountInfo(account_number);
		
		System.out.println("금융/자금관리 - 단건정보: " + accountDTO);
		model.addAttribute("dto", accountDTO);
		
	}
	
	// ------------------------------ 결산/재무제표 ------------------------------
	// 재무상태표
	@Override
	public void financialStatementsSelect(Model model) {
		IncomeStatementDTO income = new IncomeStatementDTO();
		FinancialStatementsDTO finan = new FinancialStatementsDTO();
		
		
		finan = accountDAO.selectFinancialStatements();
		income = accountDAO.selectIncomeStatement();
		
		
		System.out.println("재무상태표: " + finan);
		System.out.println("손익계산서 : " + income);
		
		/*
		 // 손익계산서
			순매출액 (총매출액-매출에누리,매출할인,매출환입)
			매출원가 ( 기초상품재고액 + 당기상품매입액(순매입액) - 기말상품재고액 )
			------------				순매입액 = 총매입액-매입에누리,매입할인,매입환출     
			    매출총이익
			- 판매비 및 관리비		*(운반비) 매입 : 총매입엑에 더한다(가산) / 매출 : 운반비계정과목 별도처리
			----------
			    영업이익
			+ 영업외수익													
			- 영업외비용
			--------------------
			    법인세차감전순이익
			- 법인세비용
			--------------
			당기순이익
			*/
		
		model.addAttribute("dto", finan);
		model.addAttribute("dto2", income);
		
	}
	// 손익계산서
	@Override
	public void incomeStatementSelect(Model model) {
		
		IncomeStatementDTO income = new IncomeStatementDTO();
		
		income = accountDAO.selectIncomeStatement();
		
		System.out.println("손익계산서: " + income);
		model.addAttribute("dto", income);
	}
	
	//jsoup
	@Override
	public void jsoup(HttpServletRequest request, Model model) {
		
		final String inflearnUrl = "https://www.inflearn.com/courses/it-programming";
		Connection conn = Jsoup.connect(inflearnUrl);
		
		List<String> list = new ArrayList<String>();
		
		try {
			Document document = conn.get();
			 Elements img = document.getElementsByClass("swiper-lazy");
			 
			 for(Element pro : img) {
				 System.out.println(pro.attr("abs:src"));
				 
				 list.add(pro.attr("abs:src"));
			 }
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		
	}
	
}
