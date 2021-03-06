<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/settings.jsp"%>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
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
				<h4 class="page-title">거래처 등록</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/sales/clientManagement">거래처 관리</a></li>
					<li class="active">거래처 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<!-- Start white-box -->
					<div class="white-box" id="white-box">
						<form class="form-horizontal" name="clientRegisterForm"
							id="clientRegisterForm"
							action="${ROOT_PATH}/sales/clientRegister/clientRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 거래처 등록
							</h2>

							<table id="client" class="display table mt-12" style="width:100%">
								<tr>
									<th style="background-color: #f1f1f1;">거래처명</th>
									
									<td><input type="text" name="name" id="name" required
										placeholder="거래처명">
										<button type="button" class="btn  btn-primary" id="search_zip_code"
											name="search_zip_code">거래처 자동등록</button>
										</td>
									
									<th style="background-color: #f1f1f1;">구분</th>
									<td><input type="text" value="법인" readonly></td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">대표자</th>
									<td><input type="text" name="ceo_name" id="ceo_name"
										required placeholder="대표자"></td>
									<th style="background-color: #f1f1f1;">사업자 번호</th>
									<td><input style="width: 50px;" type="text"
										id="register_num1" name="register_num1" maxlength="3" required
										onkeyup="nextRegisterNum1()"> - <input
										style="width: 50px;" type="text" id="register_num2"
										name="register_num2" maxlength="2" required
										onkeyup="nextRegisterNum2()"> - <input
										style="width: 50px;" type="text" id="register_num3"
										name="register_num3" maxlength="5" required
										onkeyup="nextRegisterNum3()"></td>
								</tr>
								<tr>
									<th style="background-color: #f1f1f1;">거래처 이메일</th>
									<td><input class="input" type="text" id="email1"
										name="email1" maxlength="20" style="width: 100px" required>
										@ <input class="input" type="text" id="email2" name="email2"
										maxlength="20" style="width: 80px" required> <select
										class="input" name="email3" onchange="selectEmailChk();">
											<option value="0">직접입력</option>
											<option value="naver.com">네이버</option>
											<option value="google.com">구글</option>
											<option value="nate.com">네이트</option>
											<option value="daum.net">다음</option>
									</select></td>
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
									<th rowspan="3" style="background-color: #f1f1f1;">거래처 주소</th>
									<td colspan="3">
										<input type="text" name="zip_code"
										id="zip_code" required>
										<button type="button" class="btn  btn-primary" id="search_zip_code"
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
							</table>
						</form>
						<div class="form-group mt-5">
								<div class="col-md-5 col-md-offset-5">
									<input class="btn  btn-primary" id="clientRegisterAction"
										type="button" value="등록"> 
									<input class="btn  btn-default" type="reset" value="취소">
								</div>
							</div>
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
							<table id="registeredClientList" class="display table">
								<thead>
									<tr>
										<th>거래처 번호</th>
										<th>회사명</th>
										<th>사업자번호</th>
										<th>대표자명</th>
										<th>전화번호</th>
										<th>주소</th>
										<th>등록일</th>
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
		<script src="${RESOURCES_PATH}/sales/js/clientManagement_ajax.js"></script>
		<script src="${RESOURCES_PATH}/sales/js/clientRegister.js"></script>
</body>
</html>