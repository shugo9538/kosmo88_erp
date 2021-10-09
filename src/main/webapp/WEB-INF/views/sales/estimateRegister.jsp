<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
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
					<li><a href="${ROOT_PATH}/sales/estimateManagement">견적서 관리</a></li>
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
                            			<input type="hidden" name="client_id" id="client_id" value="none">
                            			<input type="text" style="border:none;" name="client_name" id="client_name" readonly placeholder="거래처명">
                            			<button type="button" class="btn  btn-primary" id="selectClient" name="selectClient">거래처 선택</button>
                            		</td>
									<th style="background-color: #f1f1f1;">구분</th>
									<td>법인</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">대표자</th>
									<td>
										<input type="text" style="border:none;" name="client_ceo_name" id="client_ceo_name"
										readonly required>
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" style="border:none;" name="client_phone" id="client_phone" readonly required>
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
										<input class="input" style="border:none;" type="text" id="client_email" name="client_email" readonly required>
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" style="border:none;" name="client_zip_code"
										id="client_zip_code" readonly required>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px; border:none;" type="text"
										name="client_address" id="client_address" readonly>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px; border:none;" type="text"
										name="client_detail_address" id="client_detail_address" readonly required>
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="hidden" name="employee_id" id="employee_id">
                            			<input type="text" style="border:none;" name="employee_name" id="employee_name" readonly placeholder="담당자">
                            			<button type="button" class="btn  btn-primary" id="selectEmployee">담당자 선택</button>
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" style="border:none;" name="department_name" id="department_name" readonly>
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
                            			<input type="text" style="border:none;" name="employee_phone" id="employee_phone" readonly>
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" style="border:none;" name="employee_email" id="employee_email" readonly>
                            		</td>
                            	</tr>
								
							</table>

							<!-- 상품 목록 -->
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 상품 목록
							</h2>
							
							<div class="col-md-2 mt-1 mb-4">
								<button class="btn  btn-primary" type="button" id="estimateItemCall">상품 목록 불러오기</button>
							</div>
							
							<div id="estimateItemListTable">
								<table id="estimateItemList" class="table table-hover" style="width:100%">
									
								</table>
							</div> 
							
							
							<!-- 상품 등록 -->
							<div style="margin-top:30px;"></div>
							
							<h2 class="header-title" >
								<i class="fa fa-chevron-circle-right mr-2"></i> 상품 등록
							</h2>
							
							<div id="estimateRegisterTable">
								<table id="estimateRegisterList" class="table table-hover" style="width:100%">
									<thead>
										<tr>
											<th style="background-color: #f1f1f1;">상품번호</th>
											<th style="background-color: #f1f1f1;">상품명</th>
											<th style="background-color: #f1f1f1;">상품종류</th>
											<th style="background-color: #f1f1f1;">구매단가</th>
											<th style="background-color: #f1f1f1;">판매단가</th>
											<th style="background-color: #f1f1f1;">수량</th>
											<th style="background-color: #f1f1f1;">공급가액</th>
										</tr>
									</thead>
									<tbody>
										<tr>
										<td>
											<div>
												<input type="button" class="btn  btn-primary" id="selectItem" value="상품선택">
												<input type="hidden" name="item_id" id="item_id">
											</div>
											
										</td>
										<td>
											<input style="border:none;" class="form-control" name="item_name" id="item_name" type="text" placeholder="상품명" required>
										</td>
										<td>
										<input style="border:none;" class="form-control" name="category" id="category" type="text" placeholder="상품종류" required>
										</td>
										<td>
											<input style="border:none;" class="form-control" name="price" id="price" type="text" value="" placeholder="구매단가" required>
										</td>
										<td>
											<input style="border:none;" class="form-control" name="sales_price" id="sales_price" type="text" value="" placeholder="판매단가" onchange="price()" required>
										</td>
										<td>
											<input style="padding:5px; border-color:#dbdbdb; name="quantity" id="quantity" type="text"  onchange="change();" readonly required>
											<input style="padding:2px;" type="button" value=" + " onclick="add();">                                 
											<input style="padding:2px;" type="button" value=" - " onclick="del();">                                 
										</td>
										<td>
											<input style="border:none;" class="form-control" name="total_price" id="total_price" type="text" min="0" placeholder="공급가액" required>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
							 
							<div class="form-group mt-5">
								<div class="col-md-5 col-md-offset-5">
									<button class="btn  btn-primary" id="estimateRegisterAction"
										type="button">등록</button>
									<button
										class="btn  btn-default" type="reset">취소</button>
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
							<table id="registeredEstimateList" class="display table" style="width:100%">
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