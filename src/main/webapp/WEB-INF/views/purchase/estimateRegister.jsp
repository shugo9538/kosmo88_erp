<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
		
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">견적서 등록</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/purchase/estimateManagement">견적서
							관리</a></li>
					<li class="active">견적서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">	
					<!-- Start white-box -->
					<div class="white-box">
						<!-- Start form -->
						<form class="form-horizontal" name="estimateRegisterForm" id="estimateRegisterForm"
							action="${ROOT_PATH}/purchase/estimateRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>
								견적서 등록
							</h2>
							<!-- Start table -->
							<table class="display table mt-12" style="width:100%">
								<tr>
<<<<<<< HEAD
                            		<th style="background-color: #f1f1f1;">회사명</th>
                            		<td><input type="text" value="주식회사 우여곡절" readonly></td>
                            		<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td><input type="text" name="client_name" id="client_name" required placeholder="거래처명"></td>
								</tr>
								<tr>
                            		<th style="background-color: #f1f1f1;">대금결제방법</th>
                            		<td><input type="text" value="계좌이체" readonly></td>
                            		<th style="background-color: #f1f1f1;">증명구분</th>
                            		<td><input type="text" value="세금계산서(과세)" readonly></td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">담당자</th>
                            		<td><input type="text" name="client_name" id="client_name" required placeholder="담당자"></td>
									
									
								</tr>
							
							</table>
							<!-- End table -->
=======
									<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
                            			<input type="hidden" name="client_id" id="client_id">
                            			<input type="text" name="client_name" id="client_name">
                            			<input type="button" class="btn  btn-primary" id="selectClient" name="selectClient" value="거래처 선택">
                            		</td>
									<th style="background-color: #f1f1f1;">구분</th>
									<td>
										<input type="text" value="법인" readonly>
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">대표자</th>
									<td>
										<input type="text" name="client_ceo_name" id="client_ceo_name"
										readonly required placeholder="대표자">
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" name="client_phone" id="client_phone" readonly required placeholder="거래처 연락처">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
										<input class="input" type="text" id="client_email" name="client_email" readonly required placeholder="거래처 이메일">
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" name="client_zip_code"
										id="client_zip_code" readonly required placeholder="우편번호">
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="client_address" id="client_address" readonly placeholder="주소" required>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="client_detail_address" id="client_detail_address" readonly placeholder="상세주소" required>
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="hidden" name="employee_id" id="employee_id">
                            			<input type="text" name="employee_name" id="employee_name">
                            			<input type="button" class="btn  btn-primary" id="selectEmployee" value="담당자 선택">
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" name="department_name" id="department_name" readonly placeholder="담당자 부서">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
                            			<input type="text" name="employee_phone" id="employee_phone" readonly placeholder="담당자 연락처">
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" name="employee_email" id="employee_email" readonly placeholder="담당자 이메일">
                            		</td>
                            	</tr>
								
							</table>

							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 상품 등록
							</h2>
							
							<div class="col-md-2 mt-1 mb-4">
								<input class="btn  btn-primary" type="button" id="selectItem" value="거래처 상품 선택">
							</div>
							
							
							<table id="insertItemTable" class="table table-hover" style="width:100%">
								<thead>
									<tr>
										<th style="background-color: #f1f1f1;">추가 버튼</th>
										<th style="background-color: #f1f1f1;">상품명</th>
										<th style="background-color: #f1f1f1;">상품종류</th>
										<th style="background-color: #f1f1f1;">구매단가</th>
										<th style="background-color: #f1f1f1;">수량</th>
										<th style="background-color: #f1f1f1;">공급가액</th>
										<th style="background-color: #f1f1f1;">삭제 버튼</th>
									</tr>
								</thead>
								<tbody id="item-group">
									<tr id="item" style="display: none;">
										<td>
											<div role="button" class="preview col-md-12 md-5"
												id="addItem" onclick="addItem();">
												<i class="icon-plus"></i>
											</div>
										</td>
										<td><input class="form-control" name="item_name"
											type="text" placeholder="상품명" disabled readonly>
										</td>
										<td><input class="form-control" name="category"
											type="text" placeholder="상품종류" disabled readonly>
										</td>
										<td><input class="form-control" name="price"
											type="number" min="0" placeholder="구매단가" disabled readonly>
										</td>
										<td><input class="form-control" name="quantity"
											type="number" min="0" placeholder="수량" disabled>
										</td>
										<td>
											<input class="form-control" name="totalprice"
											type="number" min="0" disabled readonly>
										</td>
										<td>
											<div role="button" onclick="delItem(this);">
												<i class="icon-minus"></i>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							 
							<div class="form-group mt-5">
								<div class="col-md-5 col-md-offset-5">
									<input class="btn  btn-primary" id="estimateRegisterAction"
										type="button" value="등록"> 
									<input
										class="btn  btn-default" type="reset" value="취소">
								</div>
							</div>

>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
						</form>
						<!-- End form -->
					</div>
<<<<<<< HEAD
					<!-- End white-box -->
=======
					<!-- end white-box -->
				</div>
			</div>
			<!-- end row -->
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- Start white-box -->
					<div class="white-box">
						<h2 class="header-title">
							<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 전체 목록
						</h2>
						<div class="table-responsive">
							<table id="registeredEstimateList" class="display table">
								<thead>
									<tr>
	                                    <!-- p_estimate_list_view -->
	                                    <th>견적번호</th> 		<!-- request_id -->
	                                    <th>거래처</th>		<!-- client_name  -->
	                                    <th>거래처 대표자</th>  <!-- client_ceo_name  -->
	                                    <th>거래처 연락처</th>  <!-- client_phone  -->
	                                    <th>담당자</th>		<!-- employee_name  -->
	                                    <th>요청일자</th> 	 	<!-- begin_date  -->
	                                 </tr>
								</thead>
							</table>
						</div>
					</div>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
				</div>
			</div>
			<!--End row-->
			
										
													<!-- 
													<div class="form-group">
														<label class="col-md-1 control-label">견적번호</label>
														<div class="col-md-3">
															<p class="form-control-static">21estimate0923</p>
														</div>
							
														<label class="col-md-1 control-label">견적일자</label>
														<div class="col-md-3">
															<input class="form-control" placeholder="견적일자" type="date">
														</div>
													</div>
													 -->
													
							
													<div class="form-group">
														<label class="col-md-1 control-label">영업 담당자</label>
														<div class="col-md-3">
															<input class="form-control" placeholder="영업담당자" type="text">
														</div>
							
														<label class="col-md-1 control-label">담당자 연락처</label>
														<div class="col-md-1">
															<input class="form-control" placeholder="010" type="text"
																maxlength="3" required>
														</div>
							
														<div class="col-md-1">
															<input class="form-control" placeholder="1111" type="text"
																maxlength="4" required>
														</div>
							
														<div class="col-md-1">
															<input class="form-control" placeholder="2222" type="text"
																maxlength="4" required>
														</div>
							
														<label class="col-md-1 control-label" for="val-email">담당자
															이메일 </label>
														<div class="col-md-3">
															<input class="form-control" type="text" id="val-email"
																name="val-email" placeholder="담당자 이메일">
														</div>
													</div>
							
													<div class="form-group">
														<label class="col-md-1 control-label">대표자명</label>
														<div class="col-md-3">
															<input class="form-control" placeholder="대표자명" type="text">
														</div>
							
														<label class="col-md-1 control-label">거래처 연락처</label>
														<div class="col-md-1">
															<input class="form-control" placeholder="010" type="text"
																maxlength="3" required>
														</div>
							
														<div class="col-md-1">
															<input class="form-control" placeholder="1111" type="text"
																maxlength="4" required>
														</div>
							
														<div class="col-md-1">
															<input class="form-control" placeholder="2222" type="text"
																maxlength="4" required>
														</div>
							
														<label class="col-md-1 control-label" for="val-email">거래처
															이메일 </label>
														<div class="col-md-3">
															<input class="form-control" type="text" id="val-email"
																name="val-email" placeholder="거래처 이메일">
														</div>
													</div>
												</div>
							
												<div class="form-group"></div>
												<div class="form-group"></div>
							
												<div class="col-md-12">
													<h4 class="page-title">
														<i class="fa fa-chevron-circle-right mr-2"></i>견적서 품목내역
													</h4>
													<div class="table-responsive">
														<div class="col-md-2 mt-3 mb-3">
															<input class="btn btn-default mx-2" type="button" value="품목추가">
															<input class="btn btn-default" type="button" value="품목삭제">
														</div>
														<table id="example" class="display table">
															<thead>
																<tr>
																	<td style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></td>
																	<th>순번</th>
																	<th>품목명</th>
																	<th>종류</th>
																	<th>공급단가</th>
																	<th>수량</th>
																	<th>공급가액</th>
																</tr>
															</thead>
							
															<tbody>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>1</td>
																	<td><a href="#">백미러</a></td>
																	<td>자동차부품</td>
																	<td>250,000</td>
																	<td>100</td>
																	<td>25,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>2</td>
																	<td><a href="#">겹판 스프링</a></td>
																	<td>자동차부품</td>
																	<td>100,000</td>
																	<td>500</td>
																	<td>50,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>3</td>
																	<td><a href="#">내연기관 펌프</a></td>
																	<td>자동차부품</td>
																	<td>3,000,000</td>
																	<td>400</td>
																	<td>1,200,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>4</td>
																	<td><a href="#">기체압축기</a></td>
																	<td>자동차부품</td>
																	<td>5,000,000</td>
																	<td>200</td>
																	<td>1,000,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>5</td>
																	<td><a href="#">액체여과기</a></td>
																	<td>자동차부품</td>
																	<td>300,000</td>
																	<td>300</td>
																	<td>90,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>6</td>
																	<td><a href="#">공기여과기</a></td>
																	<td>자동차부품</td>
																	<td>400,000</td>
																	<td>150</td>
																	<td>60,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>7</td>
																	<td><a href="#">전동축</a></td>
																	<td>자동차부품</td>
																	<td>20,000,000</td>
																	<td>150</td>
																	<td>3,000,000,000</td>
																</tr>
																<tr>
																	<th style="text-align: center;"><input type="checkbox"
																		name="select" id="select"></th>
																	<td>8</td>
																	<td><a href="#">배기가스 정화용 여과기</a></td>
																	<td>자동차부품</td>
																	<td>2,000,000</td>
																	<td>150</td>
																	<td>300,000,000</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
							
												<div class="form-group">
													<div class="col-md-5 col-md-offset-5 mt-3">
														<input class="btn btn-primary mx-1" type="submit" value="등록">
														<input class="btn btn-primary" type="reset" value="취소">
													</div>
												</div>
											</div>
											<!-- End white-box -->
										</form>
		</div>
		<!-- End Wrapper-->

		<%@ include file="../common/footer.jsp"%>
</body>
</html>