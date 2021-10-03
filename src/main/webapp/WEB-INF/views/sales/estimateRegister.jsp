<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<body class="sticky-header" onload="init();">
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
					<li><a href="#">견적서 관리</a></li>
					<li class="active">견적서 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- Start white-box -->
					<div class="white-box" id="white-box">
						<form class="form-horizontal" name="estimateRegisterForm"
							id="estimateRegisterForm"
							action="${ROOT_PATH}/sales/estimateRegister/estimateRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 등록
							</h2>

							<table id="estimate" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
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
                            			<input type="button" class="btn  btn-primary" id="selectEmployee" value="담당자 선택">
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
                            	<tr>
                            		<th style="background-color: #f1f1f1;">요청일자</th>
                            		<td>
                            			<input type="date" name="" id="" >
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            	</tr>
								
							</table>
							
							

							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 상품 등록
							</h2>

							<table id="insertItemTable" class="table table-hover" style="width:100%" >
								<thead>
									<tr>
										<th style="background-color: #f1f1f1;">추가 버튼</th>
										
										<th style="background-color: #f1f1f1;">상품명</th>
										<th style="background-color: #f1f1f1;">상품종류</th>
										<th style="background-color: #f1f1f1;">판매단가</th>
										<th style="background-color: #f1f1f1;">수량</th>
										<th style="background-color: #f1f1f1;">공급가액</th>
										
									</tr>
								</thead>
								<tbody id="item-group">
									<tr>
										<td>
											<div>
											<input type="button" class="btn  btn-primary" id="selectItem" value="상품선택">
											</div>
											
										</td>
										<td>
											<input class="form-control" name="item_name" id="item_name" type="text" placeholder="상품명">
										</td>
										<td>
										<input class="form-control" name="category" id="category"
											type="text" placeholder="상품종류">
										</td>
										<td>
											<input class="form-control" name="price" id="price" type="text" value="" placeholder="판매단가">
										</td>
										<td>
											<input style="padding:5px; border-color:#dbdbdb;" name="amount" id="amount" type="text" onchange="change();">
											<input style="padding:2px;" type="button" value=" + " onclick="add();">                                 
											<input style="padding:2px;" type="button" value=" - " onclick="del();">                                 
										</td>
										<td>
											<input class="form-control" name="total_price" id="total_price" type="text" min="0" readonly> 
										</td>
									</tr>
								</tbody>
							</table>
							<div class="form-group mt-5">
								<div class="col-md-5 col-md-offset-5">
									<input class="btn  btn-primary" id="estimateRegisterAction"
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
				</div>
			</div>
			<!--End row-->
		</div>
		<!-- End Wrapper-->
		<%@ include file="../common/footer.jsp"%>
		<%@ include file="./js_sales.jsp"%>
		<script src="${RESOURCES_PATH}/sales/js/estimateManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/sales/js/estimateRegister.js"></script>
</body>
</html>