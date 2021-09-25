<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/settings.jsp"%>
<%@ include file="/WEB-INF/views/wms/common/myHeader.jsp"%>
<body class="sticky-header"
onload="currentDate()">
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
				<h4 class="page-title">차량 등록</h4>
				<ol class="breadcrumb">
					<li><a href="#">차량 관리</a></li>
					<li class="active">차량 등록</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->
			<%-- 			<%@ include file="../codeFragment/wmsMenu.jsp"%> --%>
			<ul class="nav nav-pills custom-nav">
				<li class="active"><a href="${ROOT_PATH}/wms/truck/">차량
						목록</a></li>
			</ul>

			<!--Start row-->
			<div class="row">
				<div class="col-md-12">
					<div class="white-box">
						<form class="form-horizontal">
							<h2 class="header-title">차량 정보 입력</h2>
							<div class="form-group">
								<label class="col-sm-1 control-label">차량 번호</label>
								<div class="col-sm-5">
									<input class="form-control" value="" type="text" readonly>
								</div>

								<label class="col-sm-1 control-label">등록일</label>
								<div class="col-md-5">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="mm/dd/yyyy" id="datepicker-autoclose"> <span
											class="input-group-addon b-0 text-white"
											onload="temp_currentDate()"
											><i
											class="icon-calender"></i></span>
									</div>
								</div>
 							</div>
							<div class="form-group">

								<label class="col-sm-1 control-label">차량종류(보류)</label>
								<div class="col-sm-5">
									<input class="form-control" value="" type="text">
								</div>

								<label class="col-sm-1 control-label">적재용량</label>
								<div class="col-sm-5">
									<select class="form-control">
										<option>10</option>
										<option>20</option>
										<option>30</option>
									</select>
								</div>
							</div>

						
							<button type="submit" class="btn btn-default mt-5"
								onclick="truckAddAction()">등록</button>
						</form>
					</div>
				</div>
				<!--End row-->
			</div>
			<!-- End Wrapper-->
			<%@ include file="/WEB-INF/views/common/footer.jsp"%>
			<%@ include file="/WEB-INF/views/wms/common/myFooter.jsp"%>
		</div>
	</div>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<!-- 다음 도로명주소 -->
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/daumAddress.js"></script>
</body>
</html>

