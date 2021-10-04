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
							action="${ROOT_PATH}/purchase/estimateRegister/estimateRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 견적서 등록
							</h2>

							<table id="estimate" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
                            		<td>
<<<<<<< HEAD
                            			<input type="text" name="name" id="name">
=======
                            			<input type="hidden" name="client_id" id="client_id">
                            			<input type="text" name="client_name" id="client_name">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
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
<<<<<<< HEAD
										<input type="text" name="ceo_name" id="ceo_name"
										required placeholder="대표자">
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" name="phone" id="phone" required placeholder="거래처 연락처">
=======
										<input type="text" name="client_ceo_name" id="client_ceo_name"
										readonly required placeholder="대표자">
									</td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td>
										<input type="text" name="client_phone" id="client_phone" readonly required placeholder="거래처 연락처">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td>
<<<<<<< HEAD
										<input class="input" type="text" id="email" name="email" required placeholder="거래처 이메일">
=======
										<input class="input" type="text" id="client_email" name="client_email" readonly required placeholder="거래처 이메일">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
<<<<<<< HEAD
										<input type="text" name="zip_code"
										id="zip_code" required placeholder="우편번호">
=======
										<input type="text" name="client_zip_code"
										id="client_zip_code" readonly required placeholder="우편번호">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
<<<<<<< HEAD
										name="address" id="address" placeholder="주소" required>
=======
										name="client_address" id="client_address" readonly placeholder="주소" required>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<input style="width: 350px;" type="text"
<<<<<<< HEAD
										name="detail_address" id="detail_address" placeholder="상세주소" required>
=======
										name="client_detail_address" id="client_detail_address" readonly placeholder="상세주소" required>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
									</td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td>
<<<<<<< HEAD
                            			<input type="text" name="employee_name" id="employee_name">
                            			<input type="button" class="btn  btn-primary" id="selectEmployee" value="담당자 선택"
	                             		placeholder="담당자">
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서">
=======
                            			<input type="hidden" name="employee_id" id="employee_id">
                            			<input type="text" name="employee_name" id="employee_name">
                            			<input type="button" class="btn  btn-primary" id="selectEmployee" value="담당자 선택">
	                             	</td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td>
                            			<input type="text" name="department_name" id="department_name" readonly placeholder="담당자 부서">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
                            		</td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td>
<<<<<<< HEAD
                            			<input type="text" name="employee_phone" id="employee_phone" placeholder="담당자 연락처">
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일">
=======
                            			<input type="text" name="employee_phone" id="employee_phone" readonly placeholder="담당자 연락처">
                            		</td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td>
                            			<input type="text" name="employee_email" id="employee_email" readonly placeholder="담당자 이메일">
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
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
<<<<<<< HEAD
											type="text" placeholder="상품명" disabled>
										</td>
										<td><input class="form-control" name="category"
											type="text" placeholder="상품종류" disabled>
										</td>
										<td><input class="form-control" name="price"
											type="number" min="0" placeholder="구매단가" disabled>
=======
											type="text" placeholder="상품명" disabled readonly>
										</td>
										<td><input class="form-control" name="category"
											type="text" placeholder="상품종류" disabled readonly>
										</td>
										<td><input class="form-control" name="price"
											type="number" min="0" placeholder="구매단가" disabled readonly>
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
										</td>
										<td><input class="form-control" name="quantity"
											type="number" min="0" placeholder="수량" disabled>
										</td>
<<<<<<< HEAD
										<td><input class="form-control" name="totalprice"
=======
										<td>
											<input class="form-control" name="totalprice"
>>>>>>> 6b87af15e421a548bdfb5fbc50ddafc3f5be85e0
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
		<%@ include file="./js_purchase.jsp"%>
		<script src="${RESOURCES_PATH}/purchase/js/estimateManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/purchase/js/estimateRegister.js"></script>
</body>
</html>