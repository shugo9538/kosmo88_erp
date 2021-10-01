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
                            		<td><input type="text" name="name" id="name"><input type="button" id="selectClient" name="selectClient" value="거래처 선택"
	                             		onclick="selectClient();"></td>
									<th style="background-color: #f1f1f1;">구분</th>
									<td><input type="text" value="법인" readonly></td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">대표자</th>
									<td><input type="text" name="ceo_name" id="ceo_name"
										required placeholder="대표자"></td>
									<th style="background-color: #f1f1f1;">거래처 연락처</th>
									<td><input style="width: 50px;" type="text" id="phone1"
										name="phone1" maxlength="3" required onkeyup="nextPhone1()">
										- <input style="width: 50px;" type="text" id="phone2"
										name="phone2" maxlength="4" required onkeyup="nextPhone2()">
										- <input style="width: 50px;" type="text" id="phone3"
										name="phone3" maxlength="4" required onkeyup="nextPhone3()">
									</td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td><input class="input" type="text" id="email1"
										name="email1" maxlength="20" style="width: 100px" required>
										@ <input class="input" type="text" id="email2" name="email2"
										maxlength="20" style="width: 80px" required> 
									<select
										class="input" name="email3" onchange="selectEmailChk();">
											<option value="0">직접입력</option>
											<option value="naver.com">네이버</option>
											<option value="google.com">구글</option>
											<option value="nate.com">네이트</option>
											<option value="daum.net">다음</option>
									</select>
									</td>
									
								</tr>
								<tr>
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3"><input type="text" name="zip_code"
										id="zip_code" required placeholder="우편번호">
										<button type="button" id="search_zip_code"
											name="search_zip_code" onclick="daumPostcode()">우편번호검색</button>
									</td>
								</tr>
								<tr>
									<td colspan="3"><input style="width: 350px;" type="text"
										name="address" id="address" placeholder="주소" required>
									</td>
								</tr>
								<tr>
									<td colspan="3"><input style="width: 350px;" type="text"
										name="detail_address" id="detail_address" placeholder="상세주소"
										required></td>
								</tr>
								
								<tr>
                            		<th style="background-color: #f1f1f1;">담당자</th>
                            		<td><input type="text" name="employee_name" id="employee_name"><input type="button" id="selectClient" name="selectClient" value="담당자 선택"
	                             		placeholder="담당자" onclick="selectManager();"></td>
                            		<th style="background-color: #f1f1f1;">담당자 부서</th>
                            		<td><input type="text" name="employee_dp" id="employee_dp" placeholder="담당자 부서"></td>
                            	</tr>
                            	<tr>
                            		<th style="background-color: #f1f1f1;">담당자 연락처</th>
                            		<td><input type="text" name="employee_phone" id="employee_phone" placeholder="담당자 연락처"></td>
                            		<th style="background-color: #f1f1f1;">담당자 이메일</th>
                            		<td><input type="text" name="employee_email" id="employee_email" placeholder="담당자 이메일"></td>
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
										<th style="background-color: #f1f1f1;">상품가격(구매원가)</th>
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
							<i class="fa fa-chevron-circle-right mr-2"></i> 거래처 전체 목록
						</h2>
						<div class="table-responsive">
							<table id="registeredestimateList" class="display table">
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