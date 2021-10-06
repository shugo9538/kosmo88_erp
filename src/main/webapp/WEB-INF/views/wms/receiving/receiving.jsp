<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${RESOURCES_PATH}/assets/plugins/datatables/css/jquery.dataTables-custom.css"
	rel="stylesheet" type="text/css" />

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
		<%@ include file="/WEB-INF/views/wms/common/myHeader.jspf"%>
		<!--body wrapper start-->
		<div class="wrapper">

			<!--Start Page Title-->
			<div class="page-title-box">
				<h4 class="page-title">입고 현황</h4>
				<ol class="breadcrumb">
					<li>입고 관리</li>
					<li class="active">입고 현황</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-tabs">
						<li class="nav-item active"><a id="tab_request"
							class="nav-link " data-toggle="tab" href="#request">입고 요청 현황</a></li>
						<li class="nav-item"><a id="tab-history" class="nav-link"
							data-toggle="tab" href="#history">입고 내역</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="tab-content">
						<div class="tab-pane fade active in" id="request">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 입고 요청 조회 필터
							</h2>
							<form class="form-horizontal col-md-12">
								<div class="filter">
									<div class="form-group">
										<label class="control-label col-md-1">기간</label>
										<div class="col-md-4">
											<div class="input-daterange input-group" id="date-range">
												<input type="text" class="form-control" name="start">
												<span class="input-group-addon no-border text-white">to</span>
												<input type="text" class="form-control" name="end">
											</div>
										</div>
									</div>
								</div>
							</form>
							<!-- 							<div class="col-md-12"> -->
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>입고 요청
							</h2>
							<form class="form-horizontal" id="clientManagementForm"
								name="clientManagementForm"
								action="${ROOT_PATH}/purchase/clientRegisterAction"
								method="post">
								<!-- csrf 토큰 -->
								<sec:csrfInput />
								<div class="table-responsive">
									<div class="col-md-2 mt-1 mb-4">
										<input class="btn btn-default" type="button"
											id="clientChoiceDeleteBtn" value="거래처 삭제">
									</div>

									<table id="clientList" class="display table"
										style="width: 100%">
										<thead>
											<tr>
												<td style="text-align: center"><input type="checkbox"
													id="checkAll" name="checkAll"></td>
												<th>품목</th>
												<th>수량</th>
												<th>발송</th>
												<th>창고</th>
												<th>섹션</th>
												<th>요청일</th>
											</tr>
										</thead>
									</table>
								</div>
							</form>
						</div>






						<div class="tab-pane fade" id="history">
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i> 입고 내역 조회 필터
							</h2>
							<form class="form-horizontal col-md-12">
								<div class="filter">
									<div class="form-group">
										<label class="control-label col-md-1">기간</label>
										<div class="col-md-4">
											<div class="input-daterange input-group" id="date-range">
												<input type="text" class="form-control" name="start">
												<span class="input-group-addon no-border text-white">to</span>
												<input type="text" class="form-control" name="end">
											</div>
										</div>
									</div>
								</div>
							</form>
							<!-- 							<div class="col-md-12"> -->
							<h2 class="header-title">
								<i class="fa fa-chevron-circle-right mr-2"></i>입고 내역
							</h2>
							<form class="form-horizontal" id="clientManagementForm"
								name="clientManagementForm"
								action="${ROOT_PATH}/purchase/clientRegisterAction"
								method="post">
								<!-- csrf 토큰 -->
								<sec:csrfInput />
								<div class="table-responsive">
									<div class="col-md-2 mt-1 mb-4">
										<input class="btn btn-default" type="button"
											id="clientChoiceDeleteBtn" value="삭제">
									</div>

									<table id="clientList" class="display table"
										style="width: 100%">
										<thead>
											<tr>
												<td style="text-align: center"><input type="checkbox"
													id="checkAll" name="checkAll"></td>
												<th>품목</th>
												<th>수량</th>
												<th>발송</th>
												<th>창고</th>
												<th>섹션</th>
												<th>입고일</th>
											</tr>
										</thead>
									</table>
								</div>
							</form>
						</div>





					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Wrapper-->

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>
	<%@ include file="/WEB-INF/views/wms/common/js_multiSelect.jspf"%>

	<script
		src="${RESOURCES_PATH}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/pages/table-data.js"></script>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/receiving.js"></script>
	<!-- Page Level Script -->
</body>
</html>