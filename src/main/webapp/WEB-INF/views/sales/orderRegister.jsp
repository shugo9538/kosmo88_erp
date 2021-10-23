`<%@ page language="java" contentType="text/html; charset=UTF-8"
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
				<h4 class="page-title">주문서 등록</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/sales/orderManagement">판매 관리</a></li>
					<li class="active">주문서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- Start white-box -->
					<div class="white-box" id="white-box">
						<form class="form-horizontal" name="orderRegisterForm"
							id="orderRegisterForm"
							action="${ROOT_PATH}/sales/orderRegister/orderRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 주문서 등록
							</h2>

							<table id="order" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">견적서 번호</th>
                            		<td>
										<input type="text" style="border:none;" name="request_id" id="request_id" placeholder="견적서번호" readonly>
                            			<button type="button" class="btn  btn-primary" id="selectEstimate" name="selectEstimate">견적서 선택</button>
                            		</td>
                            		<th style="background-color: #f1f1f1;">납기요청일자</th>
									<td>
										<input type="date" name="end_date" id="end_date">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
                            			<input type="hidden" id="client_id" name="client_id" value="none">
                            			<input type="text" style="border:none;" name="client_name" id="client_name" placeholder="거래처명" required readonly>
                            		</td>
									<th style="background-color: #f1f1f1;">구분</th>
									<td>
										<input type="text" style="border:none;" value="법인" readonly>
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">대표자</th>
									<td>
										<input type="text" style="border:none;" name="client_ceo_name" id="client_ceo_name"
										required placeholder="대표자" readonly>
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" style="border:none;" name="client_phone" id="client_phone" required placeholder="거래처 연락처" readonly>
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
										<input class="input" style="border:none;" type="text" id="client_email" name="client_email" required placeholder="거래처 이메일" readonly>
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" name="client_zip_code" style="border:none;" id="client_zip_code" required placeholder="우편번호" readonly>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px; border:none;" type="text" 
										name="client_address" id="client_address" placeholder="주소" required readonly>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px; border:none;" type="text"
										name="client_detail_address" id="client_detail_address" placeholder="상세주소" required readonly>
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="hidden" name="employee_id" id="employee_id" required>
                            			<input type="text" style="border:none;" name="employee_name" id="employee_name" placeholder="담당자" required readonly>
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="hidden" id="department_id" name="department_id" required>
                            			<input type="text" style="border:none;" name="department_name" id="department_name" placeholder="담당자 부서" required readonly>
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
                            			<input type="text" style="border:none;" name="employee_phone" id="employee_phone" placeholder="담당자 연락처" required readonly>
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" style="border:none;" name="employee_email" id="employee_email" placeholder="담당자 이메일" required readonly>
                            		</td>
                            	</tr>
								
							</table>

							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 주문서 상품 등록
							</h2>
							
							<div class="col-md-2 mt-1 mb-4">
								<button class="btn  btn-primary" type="button" id="orderItemCall" value="0">견적서 상품 불러오기</button>
							</div>
							
							<div id="orderItemListTable">
							<table id="orderItemList" class="table table-hover" style="width:100%">
								<thead>
									<tr>
										<th style="background-color: #f1f1f1;">상품명</th>
										<th style="background-color: #f1f1f1;">상품종류</th>
										<th style="background-color: #f1f1f1;">구매단가</th>
										<th style="background-color: #f1f1f1;">수량</th>
										<th style="background-color: #f1f1f1;">공급가액</th>
									</tr>
								</thead>
							</table>
							</div>
							 
							<div class="form-group mt-5">
								<div class="col-md-5 col-md-offset-5">
									<button class="btn  btn-primary" id="orderRegisterAction"
										type="button">등록</button>
									<button class="btn  btn-default" type="reset">취소</button>
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
							<i class="fa fa-chevron-circle-right mr-2"></i> 주문서 전체 목록
						</h2>
						<div class="table-responsive">
							<table id="registeredOrderList" class="display table" style="width:100%">
								<thead>
									<tr>
	                                    <!-- s_order_list_view -->
	                                    <th>주문번호</th> 		<!-- request_id -->
	                                    <th>판매처</th>		<!-- client_name  -->
	                                    <th>대표자</th>       <!-- client_ceo_name  -->
	                                    <th>판매처 연락처</th>  <!-- client_phone  -->
	                                    <th>담당자</th>		<!-- employee_name  -->
	                                    <th>판매일자</th> 	    <!-- begin_date  -->
	                                    <th>납기요청일자</th>	<!-- end_date  -->
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
		<%@ include file="./js_sales.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/orderManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/sales/js/orderRegister.js"></script>
</body>
</html>