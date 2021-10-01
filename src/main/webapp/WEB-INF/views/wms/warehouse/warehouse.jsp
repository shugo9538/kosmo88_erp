<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/wms/common/css_multiSelect.jspf"%>
<%@ include file="/WEB-INF/views/wms/common/css_core.jspf"%>
<%@ include file="/WEB-INF/views/wms/common/settings.jspf"%>

</head>
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


			<!-- 관리자메뉴로 빼야할듯하다 -->
			<!-- 			<ul class="nav nav-pills custom-nav"> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/modify">창고 --%>
			<!-- 						수정</a></li> -->
			<%-- 				<li class="active"><a href="${ROOT_PATH}/wms/warehouse/delete">창고 --%>
			<!-- 						삭제</a></li> -->
			<!-- 				<li class="active"><a -->
			<%-- 					href="${ROOT_PATH}/wms/stock/list?warehouseId=1">창고 재고</a></li> --%>
			<!-- 			</ul> -->


			<ul class="nav nav-tabs">
				<li class="nav-item" id="firstli"><a id="firstTab"
					class="nav-link" data-toggle="tab" href="#wsInfo"
					onload="selTab(this)">창고 정보</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#stock">전체 재고</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#rack">랙 조회</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#receiving" onclick="adjustIncludedPage();">입고</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#shipping">출고</a></li>
			</ul>

			<!--Start row-->
			<!-- 				<div class="row tab-content"> -->
			<div class="white-box">
				<div class="tab-content">
					<div class="tab-pane fade" id="wsInfo" onload="selTab(this)">
						<h2 class="header-title">창고 정보</h2>




						<label class="col-sm-1 control-label">창고 이름</label>
						<div class="col-sm-5">
							<input class="form-control" value="" type="text">
						</div>
						<div class="form-group">
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
						<input class="form-control" type="hidden"
							id="sample6_extraAddress" placeholder="참고항목"> <input
							type="button" onclick="adjustIncludedPage();" value="test">
							
							
							
							
							
						<!-- End Wrapper-->
					</div>
					<div class="tab-pane fade" id="stock">
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
					<div class="tab-pane fade" id="rack">
						<h2 class="header-title">랙 정보</h2>
						<div class="include">
							<jsp:include page="/WEB-INF/views/wms/warehouse/rackList.jsp">
								<jsp:param value="warehouseId" name="2" />
							</jsp:include>
						</div>
						<div class="tab-pane fade" id="receiving">
							<h2 class="header-title">입고</h2>
							<div class="include">
								<!-- 페이지 특정 부분만 가져오려면.. 
							1. include한 후에 태그 숨기기
							2. 애초에 페이지 띄우기 전에 파라미터 보내서 if체크하기
							-->
								<jsp:include page="/WEB-INF/views/wms/receiving/receiving.jsp">
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
								<jsp:include page="/WEB-INF/views/wms/shipping/shipping.jsp">
									<jsp:param value="warehouseId" name="2" />
								</jsp:include>
							</div>
						</div>
					</div>
				</div>

				<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
			</div>
		</div>
	</div>


	<!-- End Wrapper-->
	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>

<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
<script src="${RESOURCES_PATH}/wms/js/ms.js"></script>
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