<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/wms/common/vars.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KU ERP</title>
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
<body>
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
				<h4 class="page-title"></h4>
				<ol class="breadcrumb">
					<li>입하 관리</li>
					<li class="active">입하 지시</li>
				</ol>
				<div class="clearfix"></div>
			</div>
			<!--End Page Title-->

			<!-- 				<div class="col-sm-12"> -->
			<ul class="nav nav-tabs">
				<li class="nav-item active"><a id="tab_request"
					class="nav-link " data-toggle="tab" href="#request">입하 지시</a></li>
				<li class="nav-item"><a id="tab-history" class="nav-link"
					data-toggle="tab" href="#history">입하 내역</a></li>
			</ul>
			<div class="tab-content col-sm-12">
				<div class="tab-pane fade active in" id="request">

					<div>
						<h2 class="header-title col-xs-12 mt-5">
							<i class="fa fa-chevron-circle-right mr-2"></i> 입하 지시 목록
						</h2>

						<form class="form-horizontal col-sm-12" id="clientManagementForm"
							name="clientManagementForm"
							action="${ROOT_PATH}/purchase/clientRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<div class="table-responsive">

								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
<!-- 											<th style="text-align: center"><input type="checkBox" -->
<!-- 												class="requestId" value="450"></th> -->
											<th>구매처</th>
											<th>요청일</th>
											<th>입하예정일</th>
											<th>품목수</th>
											<th>입하지시</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="purchaseDto" items="${purchaseDtoList}">
											<tr>
<!-- 												<td style="text-align: center"><input type="checkBox" -->
<!-- 													class="requestId" value="450"></td> -->
												<td>${purchaseDto.client_name}</td>
												<td>${purchaseDto.begin_date}</td>
												<td>${purchaseDto.end_date}</td>
												<td>${purchaseDto.item_count}</td>
												<td><a id="submit" class="button"
													onclick="dispatchInbound(${purchaseDto.request_id})">입하지시</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</form>
					</div>
				</div>

				<div class="tab-pane fade" id="history">

					<div>
						<h2 class="header-title col-xs-12">
							<i class="fa fa-chevron-circle-right mr-2"></i>완료 내역
						</h2>

						<form class="form-horizontal col-sm-12" id="clientManagementForm"
							name="clientManagementForm"
							action="${ROOT_PATH}/purchase/clientRegisterAction" method="post">
							<!-- csrf 토큰 -->
							<sec:csrfInput />
							<div class="table-responsive">
<!-- 								<div class="col-sm-2 mt-1 mb-4"> -->
<!-- 									<input class="btn btn-default" type="button" -->
<!-- 										id="clientChoiceDeleteBtn" value="삭제"> -->
<!-- 								</div> -->

								<table id="clientList" class="display table" style="width: 100%">
									<thead>
										<tr>
<!-- 											<td style="text-align: center"><input type="checkbox" -->
<!-- 												id="checkAll" name="checkAll"></td> -->
											<th>구매처</th>
											<th>입하 창고</th>
											<th>요청일</th>
											<th>입하예정일</th>
										</tr>
									</thead>
									<c:forEach var="inboundDto" items="${inboundDtoList}">
										<tr>
<!-- 											<td style="text-align: center"><input type="checkBox" -->
<!-- 												class="inbound_id" value="450"></td> -->
											<td>${inboundDto.client_name}</td>
											<td>${inboundDto.warehouse_name}</td>
											<td>${inboundDto.begin_date}</td>
											<td>${inboundDto.end_date}</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
		<button type="button" onclick="location.href='/logistics_erp/test/fcmTest'" >fcmTest</button>
	<%@ include file="/WEB-INF/views/wms/common/footer.jspf"%>
	</div>
	</div>
	<!-- End Wrapper-->

	<%@ include file="/WEB-INF/views/wms/common/js_core.jspf"%>

	<script
		src="${RESOURCES_PATH}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="${RESOURCES_PATH}/assets/pages/table-data.js"></script>

	<script src="${RESOURCES_PATH}/wms/js/wms.js"></script>
	<script src="${RESOURCES_PATH}/wms/js/inbound.js"></script>
	<!-- Page Le->

	<!-- datepicker	 -->
	<script
		src="${RESOURCES_PATH}/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
	<script
		src="${RESOURCES_PATH}/assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>

	<%@ include file="/WEB-INF/views/wms/common/js_datePicker.jspf"%>
</body>
</html>