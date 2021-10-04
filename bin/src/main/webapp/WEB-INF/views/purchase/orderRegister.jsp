<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header">
	<!--Start left side Menu-->
	<%@ include file="../common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="../common/header.jsp"%>
<<<<<<< HEAD
=======

>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">발주서 등록</h4>
				<ol class="breadcrumb">
<<<<<<< HEAD
					<li>
						<a href="${ROOT_PATH}/purchase/purchaseManagement">발주서 관리</a>
					</li>
=======
					<li><a href="${ROOT_PATH}/purchase/orderManagement">발주서 관리</a></li>
>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
					<li class="active">발주서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
<<<<<<< HEAD
			<!-- Start row -->
			<div class="row">
				<!-- Start white-box -->
				<div class="white-box">
					<form class="form-horizontal">
						<div class="col-md-12">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>
								발주서
							</h2>
							<div class="form-group mt-5">
								<label class="col-md-1 control-label">회사명</label>
								<div class="col-md-3">
									<p class="form-control-static">주식회사 우여곡절</p>
								</div>
								<label class="col-md-1 control-label">거래처명</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="거래처명" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">대금결제방법</label>
								<div class="col-md-3">
									<p class="form-control-static">계좌이체</p>
								</div>
								<label class="col-md-1 control-label">증명구분</label>
								<div class="col-md-3">
									<p class="form-control-static">세금계산서(과세)</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">발주번호</label>
								<div class="col-md-3">
									<p class="form-control-static">21estimate0923</p>
								</div>
								<label class="col-md-1 control-label">발주일자</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="발주일자" type="date">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">담당자</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="담당자" type="text">
								</div>
								<label class="col-md-1 control-label">담당자 연락처</label>
								<div class="col-md-1">
									<input class="form-control" placeholder="010" type="text" maxlength="3" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="1111" type="text" maxlength="4" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="2222" type="text" maxlength="4" required>
								</div>
								<label class="col-md-1 control-label" for="val-email">담당자 이메일 </label>
								<div class="col-md-3">
									<input class="form-control" type="text" id="val-email" name="val-email" placeholder="담당자 이메일">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-1 control-label">대표자명</label>
								<div class="col-md-3">
									<input class="form-control" placeholder="대표자명" type="text">
								</div>
								<label class="col-md-1 control-label">거래처 연락처</label>
								<div class="col-md-1">
									<input class="form-control" placeholder="010" type="text" maxlength="3" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="1111" type="text" maxlength="4" required>
								</div>
								<div class="col-md-1">
									<input class="form-control" placeholder="2222" type="text" maxlength="4" required>
								</div>
								<label class="col-md-1 control-label" for="val-email">거래처 이메일 </label>
								<div class="col-md-3">
									<input class="form-control" type="text" id="val-email" name="val-email" placeholder="거래처 이메일">
								</div>
							</div>
						</div>
						<div class="col-md-12 mt-5">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>
								발주서 품목내역
							</h2>
							<div class="table-responsive">
								<div class="col-md-2 mt-3 mb-3">
									<input class="btn btn-default mx-2" type="button" value="품목추가">
									<input class="btn btn-default" type="button" value="품목삭제">
								</div>
								<table id="example" class="display table">
									<thead>
										<tr>
											<td style="text-align: center;">
												<input type="checkbox" name="select" id="select">
											</td>
											<th>순번</th>
											<th>품목명</th>
											<th>종류</th>
											<th>공급단가</th>
											<th>수량</th>
											<th>공급가액</th>
										</tr>
									</thead>
									<tbody>
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
					</form>
				</div>
				<!-- End white-box -->
			</div>
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
=======
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- Start white-box -->
					<div class="white-box" id="white-box">
						<form class="form-horizontal" name="orderRegisterForm"
							id="orderRegisterForm"
							action="${ROOT_PATH}/purchase/orderRegister/orderRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 발주서 등록
							</h2>

							<table id="order" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
                            			<input type="hidden" id="id">
                            			<input type="text" name="name" id="name">
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
										<input type="text" name="ceo_name" id="ceo_name"
										required placeholder="대표자">
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" name="phone" id="phone" required placeholder="거래처 연락처">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
										<input class="input" type="text" id="email" name="email" required placeholder="거래처 이메일">
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" name="zip_code"
										id="zip_code" required placeholder="우편번호">
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="address" id="address" placeholder="주소" required>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
										name="detail_address" id="detail_address" placeholder="상세주소" required>
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="text" name="employee_name" id="employee_name">
                            			<!-- <input type="button" class="btn  btn-primary" id="selectEmployee" value="담당자 선택">  -->
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
                            			<input type="text" name="employee_phone" id="employee_phone" placeholder="담당자 연락처">
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일">
                            		</td>
                            	</tr>
								
							</table>

							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 발주서 상품 등록
							</h2>
							
							<!-- 
							<div class="col-md-2 mt-1 mb-4">
								<input class="btn  btn-primary" type="button" id="selectItem" value="거래처 상품 선택">
							</div>
							 -->
							
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
											type="text" placeholder="상품명" disabled>
										</td>
										<td><input class="form-control" name="category"
											type="text" placeholder="상품종류" disabled>
										</td>
										<td><input class="form-control" name="price"
											type="number" min="0" placeholder="구매단가" disabled>
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
									<input class="btn  btn-primary" id="orderRegisterAction"
										type="button" value="등록"> <input
										class="btn  btn-default" type="reset" value="취소">
								</div>
							</div>

						</form>
					</div>
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
							<i class="fa fa-chevron-circle-right mr-2"></i> 발주서 전체 목록
						</h2>
						<div class="table-responsive">
							<table id="registeredOrderList" class="display table">
								<thead>
									<tr>
	                                    <!-- p_order_list_view -->
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
				</div>
			</div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="./js_purchase.jsp"%>
		<script src="${RESOURCES_PATH}/purchase/js/orderManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/purchase/js/orderRegister.js"></script>
>>>>>>> 93c57a16fe887c0213199b3599ad6f190506bdb7
</body>
</html>