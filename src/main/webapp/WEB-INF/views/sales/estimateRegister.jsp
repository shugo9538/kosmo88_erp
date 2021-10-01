<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
							id="clientRegisterForm"
							action="${ROOT_PATH}/sales/clientRegister/estimateRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 등록
							</h2>

							<table class="display table mt-12">
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
                            			<input type="text" name="name" id="name">
                            			<input type="button" id="selectClient" name="selectClient" value="거래처 선택"
	                             			onclick="selectClient();">
	                             	</td>
                            		<th style="background-color: #f1f1f1;">구분</th>
                            		<td><input type="text" value="법인" readonly></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">대표자</th>
                            		<td><input type="text" name="ceo_name" id="ceo_name" placeholder="대표자"></td>
                            		<th style="background-color: #f1f1f1;">거래처 연락처</th>
                            		<td><input type="text" name="phone" id="phone" placeholder="거래처 연락처"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">거래처 이메일</th>
                            		<td colspan="3"><input type="text" name="email" id="email" placeholder="거래처 이메일"></td>
                            	</tr>
                            	<tr>
                            		<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
                            		<td colspan="3">
                            			<input type="text" name="zip_code" id="zip_code" placeholder="우편번호">
                            		</td>
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="address" id="address" placeholder="주소">
                            		</td>
                            	</tr>
                            	<tr>
                            		<td colspan="3">
                            			<input style="width:350px;" type="text" name="detail_address" id="detail_address" placeholder="상세주소">
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
                            			<input type="text" name="employee_name" id="employee_name">
                            			<input type="button" id="selectEmployee" name="selectEmployee" value="담당자 선택"
	                             			onclick="selectEmployee();">
	                             	</td>
	                             		
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td><input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td><input type="text" name="employee_phone" id="employee_phone" placeholder="담당자 연락처"></td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td><input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">상품명</th>
                            		<td><input type="text" name="product_name" id="product_name"><input type="button" id="selectClient" name="selectClient" value="상품 선택"
	                             		placeholder="상품명" onclick="selectProduct();"></td>
                            		<th style="background-color: #f1f1f1;">상품수량</th>
                            		<td><input type="number" name="product_quantity" id="product_quantity" placeholder="상품수량"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">구매가</th>
                            		<td><input type="number" name="product_price" id="product_price" placeholder="구매가"></td>
                            		<th style="background-color: #f1f1f1;">판매가</th>
                            		<td><input type="number" name="sale_price" id="sale_price" placeholder="판매가"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">요청일자</th>
                            		<td><input type="date" name="start_date" id="start_date"></td>
                            		<th style="background-color: #f1f1f1;">납기일자</th>
                            		<td><input type="date" name="end_date" id="end_date"></td>
                            	</tr>
                            </table>
                            
                            <h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 상품 등록
							</h2>

							<table id="insertItemTable" class="table table-hover" style="width:100%">
								<thead>
									<tr>
										<th style="background-color: #f1f1f1;">추가 버튼</th>
										<th style="background-color: #f1f1f1;">상품명</th>
										<th style="background-color: #f1f1f1;">상품종류</th>
										<th style="background-color: #f1f1f1;">상품가격(판매가)</th>
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
											type="text" placeholder="상품명" disabled></td>
										<td><input class="form-control" name="category"
											type="text" placeholder="상품종류" disabled></td>
										<td><input class="form-control" name="price"
											type="number" min="0" placeholder="상품가격" disabled></td>
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
									<input class="btn  btn-default" type="reset" value="취소">
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
							<table id="registeredClientList" class="display table">
								<thead>
									<tr>
										<th>견적번호</th> 		<!--  request_id  -->
                                        <th>거래처명</th>		<!--  client_name -->
                                        <th>거래처대표자명</th> <!--  client_ceo_name -->
                                        <th>거래처연락처</th>  <!--  client_phone -->
                                        <th>담당자</th>		<!-- employee_name -->
                                        <th>요청일자</th> 	 	<!--  begin_date  -->
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