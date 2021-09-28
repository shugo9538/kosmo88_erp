<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/settings.jsp"%>
<%@ include file="/WEB-INF/views/wms/common/myHeader.jsp"%>
<body class="sticky-header">

	<!--Start left side Menu-->
	<%@ include file="/WEB-INF/views/common/left_side.jsp"%>
	<!--End left side menu-->
	<!-- main content start-->
	<div class="main-content">
		<!-- header section start-->
		<%@ include file="/WEB-INF/views/common/header.jsp"%>
		<!--body wrapper start-->
		<div class="wrapper">
			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">창고 정보</h4>
				<ol class="breadcrumb">
					<li><a href="${ROOT_PATH}/wms/warehouse/">창고 목록</a></li>
					<li class="active">창고 정보</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/modify">창고
						수정</a></li>
				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/delete">창고
						삭제</a></li>
				<li class="active"><a
					href="${ROOT_PATH}/wms/stock/list?warehouseId=1">창고 재고</a></li>
			</ul>
			<ul class="nav nav-tabs">
				<li class="nav-item" id="firstli"><a id="firstTab"
					class="nav-link" data-toggle="tab" href="#wsInfo"
					onload="selTab(this)">창고 정보</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#rack">랙</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#receiving" onclick="adjustIncludedPage();">입고</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#shipping">출고</a></li>
			</ul>
			<!--Start row-->
			<!-- 				<div class="row tab-content"> -->
			<div class="white-box">
				<div class="tab-content">
					<!-- 					<div class="tab-pane fade show active" id="wsInfo"> -->
					<div class="tab-pane fade" id="wsInfo" onload="selTab(this)">
						<h2 class="header-title">창고 정보</h2>
						<div class="form-group">
							<label class="col-sm-1 control-label">창고 번호</label>
							<div class="col-sm-5">
								<input class="form-control" value="" type="text" readonly>
							</div>


							<label class="col-sm-1 control-label">등록일</label>
							<div class="col-md-5">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="mm/dd/yyyy" id="datepicker-autoclose"> <span
										class="input-group-addon b-0 text-white"><i
										class="icon-calender"></i></span>
								</div>
							</div>
						</div>
						<div class="form-group">
						<label class="col-sm-1 control-label">창고 이름</label>
						<div class="col-sm-5">
							<input class="form-control" value="" type="text">
						</div>

						<label class="col-sm-1 control-label">창고 종류</label>
						<div class="col-sm-5">
							<select class="form-control">
								<option>일반창고</option>
								<option>야적창고</option>
								<option>냉동창고</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">주소</label>
						<div class="col-sm-2">
							<input class="form-control col-sm-2" type="text"
								id="sample6_postcode" placeholder="우편번호">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1"></div>
						<div class="col-sm-5">
							<input class="form-control" type="text" id="sample6_address"
								placeholder="주소"><br>
						</div>
						<div class="col-sm-6">
							<input class="form-control" type="text"
								id="sample6_detailAddress" placeholder="상세주소">
						</div>
					</div>
					<input class="form-control" type="hidden" id="sample6_extraAddress"
						placeholder="참고항목"> <input type="button"
						onclick="adjustIncludedPage();" value="test">
					<!-- End Wrapper-->
					<div class="include">
						<h2 class="header-title">재고 정보</h2>
						<!-- 페이지 특정 부분만 가져오려면.. 
							1. include한 후에 태그 숨기기
							2. 애초에 페이지 띄우기 전에 파라미터 보내서 if체크하기
							-->
						<jsp:include page="/WEB-INF/views/wms/stock/stockList.jsp">
							<jsp:param value="warehouseId" name="2" />
						</jsp:include>
					</div>
				</div>
				<!-- 				</div> -->

				<div class="tab-pane fade" id="rack">
					<!-- 					<div class="col-md-12"> -->
					<h2 class="header-title">랙 정보</h2>
					<div class="include">
						<jsp:include page="/WEB-INF/views/wms/warehouse/rackList.jsp">
							<jsp:param value="warehouseId" name="2" />
						</jsp:include>
					</div>
					<!-- 						<div class="table-responsive"> -->
					<!-- 							<table class="table table-hover"> -->
					<!-- 								<thead> -->
					<!-- 									<tr> -->
					<!-- 										<th>#</th> -->
					<!-- 										<th>랙 이름</th> -->
					<!-- 										<th>랙창창</th> -->
					<!-- 										<th>창창랙</th> -->
					<!-- 										<th>랙 상태</th> -->
					<!-- 										<th>포화도</th> -->
					<!-- 									</tr> -->
					<!-- 								</thead> -->
					<!-- 								<tbody> -->
					<!-- 									<tr> -->
					<!-- 										<td>1</td> -->
					<%-- 										<td><a href="${ROOT_PATH}/wms/warehouse/viewRack">본사 --%>
					<!-- 												랙</a></td> -->
					<!-- 										<td>랙창창</td> -->
					<!-- 										<td>고창랙</td> -->
					<!-- 										<td><span class="label label-warning">랙중</span></td> -->
					<!-- 										<td> -->
					<!-- 											<div class="progress progress-striped progress-sm"> -->
					<!-- 												<div class="progress-bar progress-bar-warning" -->
					<!-- 													style="width: 25%;"></div> -->
					<!-- 											</div> -->
					<!-- 										</td> -->
					<!-- 									</tr> -->
					<!-- 									<tr> -->
					<!-- 										<td>2</td> -->
					<!-- 										<td>유라 랙</td> -->
					<!-- 										<td>랙창창</td> -->
					<!-- 										<td>고창랙</td> -->
					<!-- 										<td><span class="label label-warning">랙중</span></td> -->
					<!-- 										<td> -->
					<!-- 											<div class="progress progress-striped progress-sm"> -->
					<!-- 												<div class="progress-bar progress-bar-warning" -->
					<!-- 													style="width: 90%;"></div> -->
					<!-- 											</div> -->
					<!-- 										</td> -->
					<!-- 									</tr> -->
					<!-- 								</tbody> -->
					<!-- 							</table> -->
					<!-- 						</div> -->
				</div>
				<%-- 					<jsp:include page="/WEB-INF/views/wms/rack/rackList.jsp"> --%>
				<%-- 						<jsp:param value="2" name="warehouseNum" /> --%>
				<%-- 					</jsp:include> --%>

				<div class="tab-pane fade" id="receiving">
					<h2 class="header-title">입고</h2>
					<div class="include">
						<!-- 페이지 특정 부분만 가져오려면.. 
							1. include한 후에 태그 숨기기
							2. 애초에 페이지 띄우기 전에 파라미터 보내서 if체크하기
							-->
						<jsp:include page="/WEB-INF/views/wms/receiving/receivingList.jsp">
							<jsp:param value="warehouseId" name="2" />
						</jsp:include>
					</div>
				</div>
				<div class="tab-pane fade" id="shipping">
					<h2 class="header-title">출고</h2>
					<div class="include">
						<!-- 페이지 특정 부분만 가져오려면.. 
							1. include한 후에 태그 숨기기
							2. 애초에 페이지 띄우기 전에 파라미터 보내서 if체크하기
							-->
						<jsp:include page="/WEB-INF/views/wms/shipping/shippingList.jsp">
							<jsp:param value="warehouseId" name="2" />
						</jsp:include>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- End Wrapper-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	<%@ include file="/WEB-INF/views/wms/common/myFooter.jsp"%>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<!-- 일단 돌려막기로 자바스크립트로 active 처리... -->
	<script>
		// 			  				window.onload = selTab(); 
		var tempFunc = function() {
			selTab();
			initDatePicker();
			adjustIncludedPage();
		}
		window.onload = tempFunc;
	</script>
</body>
</html>